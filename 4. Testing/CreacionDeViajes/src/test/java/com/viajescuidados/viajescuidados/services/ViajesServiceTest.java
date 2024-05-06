package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.repositories.ViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.interfaces.IViajesService;
import com.viajescuidados.services.utils.ubicaciones.CalculadoraDemora;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ViajesServiceTest {
    @Mock
    ViajesRepository viajesRepository;
    @Mock
    CalculadoraDemora calculadoraDemora;
    @Mock
    IPersonaServiceInternal personaService;

    @InjectMocks
    ViajesService viajesService;

    @Test
    @DisplayName("Crear viaje")
    public void crearViajeTest() {
        UbicacionDTO origen = new UbicacionDTO("",-32L, -64L);
        UbicacionDTO destino = new UbicacionDTO("",-32L, -65L);
        ViajeDTO viajeACrear = ViajeDTO.builder()
                .cuidadores(List.of(2,3))
                .origen(origen)
                .destino(destino)
                .build();
        Persona personaMock = Persona.builder()
                .id(1)
                .nombre("Franco")
                .apellido("Moises")
                .build();
        Persona cuidadorMock = Persona.builder()
                .id(2)
                .nombre("Agus")
                .apellido("Lopez")
                .build();
        Persona cuidadorMock2 = Persona.builder()
                .id(3)
                .nombre("Cande")
                .apellido("Garcia")
                .build();
        when(personaService.buscarPersonaPorId(1)).thenReturn(personaMock);
        when(personaService.buscarPersonaPorId(2)).thenReturn(cuidadorMock);
        when(personaService.buscarPersonaPorId(3)).thenReturn(cuidadorMock2);
        when(calculadoraDemora.calcularDemoraEntre(any(),any())).thenReturn(2L);

        ViajeResponseDTO viajeCreado = viajesService.crearViaje(viajeACrear,1);
        verify(personaService, atLeast(3)).buscarPersonaPorId(any());


        assertEquals("NO_INICIADO", viajeCreado.getEstado());
        assertEquals(2L, viajeCreado.getDuracionEstimadaEnMins());
        assertEquals(List.of(2,3), viajeCreado.getCuidadores());
    }
}
