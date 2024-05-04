package com.viajescuidados.viajescuidados.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.interfaces.IPersonasService;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ViajeServiceTest {

    @Mock
    private IViajesRepository viajesRepository;

    @Mock
    private IPersonaServiceInternal personasService;

    @Mock
    private ICalculadoraDemora calculadoraDemora;

    @InjectMocks
    private ViajesService viajesService;

    private ObjectWriter writer;

    private Integer personaIdResponse;

    private UbicacionDTO origenDTO;
    private UbicacionDTO destinoDTO;

    private ViajeResponseDTO viajeResponse;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        personaIdResponse = 1;

        origenDTO = new UbicacionDTO("123 Main St", 40L, 70L);
        destinoDTO = new UbicacionDTO("456 Elm St", 42L, 72L);

        viajeResponse = ViajeResponseDTO.builder()
                .personaId(personaIdResponse)
                .cuidadores(Arrays.asList(3, 4, 5))
                .origen(origenDTO)
                .destino(destinoDTO)
                .estado("NO_INICIADO")
                .duracionEstimadaEnMins(2L)
                .build();
    }

    @Test
    @DisplayName("Verificar el correcto funcionamiento de la creación de viajes")
    public void crearViajeTest() throws JsonProcessingException {

        // Arrange

        Ubicacion origen = new Ubicacion("123 Main St", 40L, 70L);
        Ubicacion destino = new Ubicacion("456 Elm St", 42L, 72L);


        ViajeDTO viajeDTO = new ViajeDTO(Arrays.asList(3, 4, 5), origenDTO, destinoDTO);

        Persona persona = Persona.builder()
                .id(1)
                .nombre("Juan")
                .apellido("Perez")
                .build();

        Persona persona3 = Persona.builder()
                .id(3)
                .nombre("Nombre3")
                .apellido("Apellido3")
                .build();

        Persona persona4 = Persona.builder()
                .id(4)
                .nombre("Nombre4")
                .apellido("Apellido4")
                .build();

        Persona persona5 = Persona.builder()
                .id(5)
                .nombre("Nombre5")
                .apellido("Apellido5")
                .build();


        // Act
        when(personasService.buscarPersonaPorId(personaIdResponse)).thenReturn(persona);

        when(personasService.buscarPersonaPorId(3)).thenReturn(persona3);
        when(personasService.buscarPersonaPorId(4)).thenReturn(persona4);
        when(personasService.buscarPersonaPorId(5)).thenReturn(persona5);

        when(calculadoraDemora.calcularDemoraEntre(origen, destino)).thenReturn(2L);

        // Assert
        ViajeResponseDTO viajeResponseDTOReal = viajesService.crearViaje(viajeDTO, personaIdResponse);
        String payloadJSON = writer.writeValueAsString(viajeResponse);
        String responseJSON = writer.writeValueAsString(viajeResponseDTOReal);

        verify(viajesRepository).guardar(any(Viaje.class));
        assertEquals(payloadJSON, responseJSON);

    }



}
