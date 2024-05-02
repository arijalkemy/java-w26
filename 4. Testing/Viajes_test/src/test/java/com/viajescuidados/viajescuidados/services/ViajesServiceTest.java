package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ViajesServiceTest {

    @Mock
    private IViajesRepository viajesRepository;

    @Mock
    private IPersonaServiceInternal personaService;

    @Mock
    private ICalculadoraDemora calculadorDemora;

    @InjectMocks
    private ViajesService viajesService;

    private ViajeDTO viajeDTO;
    private Integer personaId;
    private UbicacionDTO origen;
    private UbicacionDTO destino;
    private Persona persona;
    private Viaje viaje;

    @BeforeEach
    void setUp() {
        origen = new UbicacionDTO("Cra 123", 223L, 123L);
        destino = new UbicacionDTO("Cra 456", 223L, 123L);
        viajeDTO = new ViajeDTO(Arrays.asList(1, 2, 3), origen, destino);
        personaId = 1;

        persona = new Persona();
        viaje = ViajeMapper.crearViaje(viajeDTO);
        viaje.setPersona(persona);
    }

    @Test
    @DisplayName("Crear un nuevo viaje")
    void crearViaje() {
        // Arrange

        when(personaService.buscarPersonaPorId(anyInt())).thenReturn(persona);
        when(calculadorDemora.calcularDemoraEntre(any(), any())).thenReturn(100L);

        // Act
        ViajeResponseDTO resultado = viajesService.crearViaje(viajeDTO, personaId);

        // Assert
        assertNotNull(resultado);
        verify(personaService, atLeast(1)).buscarPersonaPorId(anyInt());
        verify(calculadorDemora).calcularDemoraEntre(any(), any());
        verify(viajesRepository).guardar(any(Viaje.class));
    }

    @Test
    @DisplayName("Comenzar un viaje")
    void comenzarViaje() {
        // Arrange
        viaje.setEstado(EstadoViaje.NO_INICIADO);

        when(viajesRepository.buscarPorId(anyInt())).thenReturn(Optional.of(viaje));

        // Act
        ViajeResponseDTO resultado = viajesService.comenzarViaje(1);

        // Assert
        assertNotNull(resultado);
        verify(viajesRepository).buscarPorId(anyInt());
        verify(viajesRepository).modificar(any(Viaje.class));
    }

    @Test
    @DisplayName("Comenzar un viaje - Viaje no encontrado")
    void comenzarViaje_NotFound() {
        // Arrange
        when(viajesRepository.buscarPorId(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> viajesService.comenzarViaje(1));

        verify(viajesRepository).buscarPorId(anyInt());
        verify(viajesRepository, never()).modificar(any(Viaje.class));
    }

}