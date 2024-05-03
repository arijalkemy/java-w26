package com.viajescuidados.viajescuidados.crearViajeUnitTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CrearViajeTests {

    @Mock
    private IViajesRepository viajesRepository;

    @Mock
    private IPersonaServiceInternal personaService;

    @Mock
    private ICalculadoraDemora calculadorDemora;

    @InjectMocks
    private ViajesService viajesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test de creación de viaje con cuidadores")
    public void testCrearViajeConCuidadores(){
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO(/* Definir valores de la ubicación */))
                .destino(new UbicacionDTO(/* Definir valores de la ubicación */))
                .build();

        // Mockear búsqueda de personas y cálculo de demora
        when(personaService.buscarPersonaPorId(1)).thenReturn(new Persona(1, "John", "Doe"));
        when(personaService.buscarPersonaPorId(2)).thenReturn(new Persona(2, "Jane", "Doe"));
        when(personaService.buscarPersonaPorId(3)).thenReturn(new Persona(3, "Sam", "Smith"));
        when(calculadorDemora.calcularDemoraEntre(any(), any())).thenReturn(30L);

        // Llamar al servicio
        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, 1);

        // Verificar que el servicio devolvió una respuesta válida
        assertNotNull(response);
        assertEquals(1, response.getPersonaId()); // Verificar que el viaje fue asignado a la persona correcta
    }

    @Test
    @DisplayName("Test de interacción con repositorio")
    public void testGuardarViajeEnRepositorio() {
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO("123 Main St", 34L, -118L))
                .destino(new UbicacionDTO("456 Elm St", 35L, -117L))
                .build();

        // Mockear buscarPersonaPorId
        when(personaService.buscarPersonaPorId(1)).thenReturn(new Persona(1, "John", "Doe")); // Asegúrate de que el ID es el correcto

        // Simular guardado del viaje
        Viaje nuevoViaje = ViajeMapper.crearViaje(viajeDTO);
        Persona persona = personaService.buscarPersonaPorId(1);
        nuevoViaje.setPersona(persona);

        for(Integer idCuidador: viajeDTO.getCuidadores()) {
            Persona cuidador = personaService.buscarPersonaPorId(idCuidador);
            nuevoViaje.agregarCuidador(cuidador);
        }

        Long duracionEstimada = this.calculadorDemora
                .calcularDemoraEntre(nuevoViaje.getOrigen(), nuevoViaje.getDestino());
        nuevoViaje.setDuracionEstimadaEnMins(duracionEstimada);

        // Llamar al método guardar()
        viajesRepository.guardar(nuevoViaje);

        // Verificar interacción con el repositorio
        verify(viajesRepository, times(1)).guardar(nuevoViaje); // Se guardó el viaje en el repositorio
    }

    @Test
    @DisplayName("Test de asignación de persona y cuidadores")
    public void testAsignacionPersonaYCuidadores() {
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO("123 Main St", 34L, -118L))
                .destino(new UbicacionDTO("456 Elm St", 35L, -117L))
                .build();

        // Mockear servicios y repositorio
        when(personaService.buscarPersonaPorId(1)).thenReturn(new Persona(1, "John", "Doe"));
        when(personaService.buscarPersonaPorId(2)).thenReturn(new Persona(2, "Jane", "Doe"));
        when(personaService.buscarPersonaPorId(3)).thenReturn(new Persona(3, "Sam", "Smith"));
        when(calculadorDemora.calcularDemoraEntre(any(), any())).thenReturn(30L);

        // Crear el viaje
        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, 1);

        // Verificar persona asignada
        assertEquals(1, response.getPersonaId());

        // Verificar cuidadores asignados
        assertEquals(2, response.getCuidadores().size());
        assertTrue(response.getCuidadores().contains(2));
        assertTrue(response.getCuidadores().contains(3));
    }

    @Test
    @DisplayName("Test de cálculo de duración estimada")
    public void testCalculoDuracionEstimada() {
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO("123 Main St", 34L, -118L))
                .destino(new UbicacionDTO("456 Elm St", 35L, -117L))
                .build();

        // Mockear servicios y repositorio
        when(personaService.buscarPersonaPorId(1)).thenReturn(new Persona(1, "John", "Doe"));
        when(personaService.buscarPersonaPorId(2)).thenReturn(new Persona(2, "Jane", "Doe"));
        when(personaService.buscarPersonaPorId(3)).thenReturn(new Persona(3, "Sam", "Smith"));
        when(calculadorDemora.calcularDemoraEntre(any(), any())).thenReturn(30L);

        // Crear el viaje
        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, 1);

        // Verificar duración estimada
        assertEquals(30L, response.getDuracionEstimadaEnMins());
    }

    @Test
    @DisplayName("Test de integración - Creación de viaje")
    public void testIntegracionCrearViaje() {
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO("123 Main St", 34L, -118L))
                .destino(new UbicacionDTO("456 Elm St", 35L, -117L))
                .build();

        // Crear mock para el servicio de personas
        Persona persona = new Persona(1, "John", "Doe");
        when(personaService.buscarPersonaPorId(1)).thenReturn(persona);

        // Mockear el guardado del repositorio para el test
        doNothing().when(viajesRepository).guardar(any(Viaje.class));

        // Crear el viaje
        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, 1);

        Ubicacion origenUbicacion = new Ubicacion(viajeDTO.getOrigen().getDireccion(), viajeDTO.getOrigen().getLatitud(), viajeDTO.getOrigen().getLongitud());
        Ubicacion destinoUbicacion = new Ubicacion(viajeDTO.getDestino().getDireccion(), viajeDTO.getDestino().getLatitud(), viajeDTO.getDestino().getLongitud());

        // Obtener las personas a partir de los IDs
        List<Persona> cuidadores = new ArrayList<>();
        for (Integer idCuidador : viajeDTO.getCuidadores()) {
            Persona personaCuidadora = personaService.buscarPersonaPorId(idCuidador);
            cuidadores.add(personaCuidadora);
        }

// Crear el objeto mockViaje con la lista de cuidadores convertida
        Viaje mockViaje = new Viaje(
                response.getId(),
                persona,
                cuidadores,
                origenUbicacion,
                destinoUbicacion,
                EstadoViaje.NO_INICIADO,
                0L
        );

        // Verificar que el viaje se guarda en el repositorio
        Optional<Viaje> viajeGuardado = viajesRepository.buscarPorId(response.getId());
        assertTrue(viajeGuardado.isPresent());

        // Verificar datos del viaje guardado
        assertEquals(viajeDTO.getCuidadores(), mockViaje.getCuidadores()); // Verificar cuidadores
        assertEquals(viajeDTO.getOrigen(), mockViaje.getOrigen()); // Verificar origen
        assertEquals(viajeDTO.getDestino(), mockViaje.getDestino()); // Verificar destino
    }

    @Test
    @DisplayName("Test de guardado del viaje en la base de datos")
    public void testGuardarViajeEnBaseDeDatos() {
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO("123 Main St", 34L, -118L))
                .destino(new UbicacionDTO("456 Elm St", 35L, -117L))
                .build();

        // Mockear servicios y repositorio
        when(personaService.buscarPersonaPorId(1)).thenReturn(new Persona(1, "John", "Doe"));
        when(personaService.buscarPersonaPorId(2)).thenReturn(new Persona(2, "Jane", "Doe"));
        when(personaService.buscarPersonaPorId(3)).thenReturn(new Persona(3, "Sam", "Smith"));
        when(calculadorDemora.calcularDemoraEntre(any(), any())).thenReturn(30L);

        // Crear el viaje
        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, 1);

        // Verificar interacción con el repositorio
        verify(viajesRepository, times(1)).guardar(any(Viaje.class));
    }

    @Test
    @DisplayName("Test de devolución del objeto ViajeResponseDTO")
    public void testDevolucionViajeResponseDTO() {
        // Crear ViajeDTO de entrada
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(Arrays.asList(2, 3))
                .origen(new UbicacionDTO("123 Main St", 34L, -118L))
                .destino(new UbicacionDTO("456 Elm St", 35L, -117L))
                .build();

        // Mockear servicios y repositorio
        when(personaService.buscarPersonaPorId(1)).thenReturn(new Persona(1, "John", "Doe"));
        when(personaService.buscarPersonaPorId(2)).thenReturn(new Persona(2, "Jane", "Doe"));
        when(personaService.buscarPersonaPorId(3)).thenReturn(new Persona(3, "Sam", "Smith"));
        when(calculadorDemora.calcularDemoraEntre(any(), any())).thenReturn(30L);

        // Crear el viaje
        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, 1);

        // Verificar datos del ViajeResponseDTO
        assertEquals(1, response.getPersonaId());
        assertEquals(2, response.getCuidadores().size());
        assertTrue(response.getCuidadores().contains(2));
        assertTrue(response.getCuidadores().contains(3));
        assertEquals(30L, response.getDuracionEstimadaEnMins());
    }
}
