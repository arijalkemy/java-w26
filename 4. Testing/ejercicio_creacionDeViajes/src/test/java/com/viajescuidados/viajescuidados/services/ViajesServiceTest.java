package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViajesServiceTest {
    @Mock
    private IViajesRepository viajesRepository;
    @Mock
    private IPersonaServiceInternal personaServiceInternal;
    @Mock
    private ICalculadoraDemora calculadoraDemora;

    @InjectMocks
    private ViajesService viajesService;

    @Test
    @DisplayName("Se crea un viaje exitosamente")
    void crearViajeTest() {
        // Arrange
        when(personaServiceInternal.buscarPersonaPorId(anyInt())).thenReturn(crearPersona());
        when(calculadoraDemora.calcularDemoraEntre(
            any(Ubicacion.class),
            any(Ubicacion.class)
        )).thenReturn(2L);

        ViajeResponseDTO expectedResult = crearViajeResponseDTO();

        // Act
        ViajeResponseDTO result = viajesService.crearViaje(crearViajeDTO(), 1);

        // Assert
        assertEquals(result, expectedResult);
    }

    @Test


    private Persona crearPersona() {
        return new Persona(
                1,
                "Carlos",
                "Perez"
        );
    }

    private ViajeDTO crearViajeDTO() {
        UbicacionDTO origen = new UbicacionDTO(
                "Calle 123",
                2L,
                4L
        );

        UbicacionDTO destino = new UbicacionDTO(
                "Calle 123",
                10L,
                12L
        );

        List<Integer> cuidadores = new ArrayList<Integer>();
        cuidadores.add(1);

        return new ViajeDTO(
            cuidadores,
            origen,
            destino
        );
    }

    private ViajeResponseDTO crearViajeResponseDTO() {
        List<Persona> cuidadores = new ArrayList<Persona>();
        cuidadores.add(crearPersona());

        Viaje viaje = new Viaje(
            null,
            crearPersona(),
            cuidadores,
            new Ubicacion(
                    "Calle 123",
                    2L,
                    4L
            ),
            new Ubicacion(
                    "Calle 123",
                    10L,
                    12L
            ),
            EstadoViaje.NO_INICIADO,
            2L,
            null,
            null
        );

        return ViajeMapper.crearViajeResponseDTO(viaje);
    }
}
