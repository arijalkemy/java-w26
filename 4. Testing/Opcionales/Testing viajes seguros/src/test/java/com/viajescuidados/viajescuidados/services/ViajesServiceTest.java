package com.viajescuidados.viajescuidados.services;

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
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class ViajesServiceTest {

    @Mock
    IViajesRepository viajesRepository;

    @Mock
    IPersonaServiceInternal personasService;

    @Mock
    ICalculadoraDemora calculadoraDemora;


    @InjectMocks
    ViajesService viajesService;

    @Test
    void crearViajeTest() {
        UbicacionDTO origenDTO = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destinoDTO = new UbicacionDTO("", (long) -34.5, (long) -59);
        int personaId=3;
        Persona persona = new Persona(
                personaId,
                "Juan",
                "Perez"
        );

        Persona cuidador1 = new Persona(
                1,
                "Cuidador",
                "1"
        );
        Persona cuidador2 = new Persona(
                2,
                "Cuidador",
                "2"
        );

        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origenDTO, destinoDTO);

        Ubicacion origen = new Ubicacion("", (long) -34.5, (long) -58.5);
        Ubicacion destino = new Ubicacion("", (long) -34.5, (long) -59);

        Viaje viaje = Viaje.builder()
                .origen(origen)
                .destino(destino)
                .build();

        viaje.setPersona(persona);
        viaje.setCuidadores(List.of(cuidador1, cuidador2));
        viaje.setDuracionEstimadaEnMins(2L);

        when(personasService.buscarPersonaPorId(personaId))
                .thenReturn(persona);
        when(personasService.buscarPersonaPorId(1))
                .thenReturn(cuidador1);
        when(personasService.buscarPersonaPorId(2))
                .thenReturn(cuidador2);

        when(calculadoraDemora.calcularDemoraEntre(any(), any()))
                .thenReturn(2L);

        ViajeResponseDTO resultDTO = viajesService.crearViaje(viajeDTO, personaId);

        verify(viajesRepository, atLeast(1)).guardar(any(Viaje.class));


        // fix this warning

        try (MockedStatic<ViajeMapper> mocked = mockStatic(ViajeMapper.class)) {
            mocked.when(() -> ViajeMapper.crearViajeResponseDTO(any(Viaje.class)))
                    .thenReturn(ViajeResponseDTO.builder()
                            .id(1)
                            .personaId(personaId)
                            .cuidadores(List.of(1, 2))
                            .origen(origenDTO)
                            .destino(destinoDTO)
                            .estado("PENDIENTE")
                            .duracionEstimadaEnMins(2L)
                            .build());
        }


        Assertions.assertEquals(viaje.getDuracionEstimadaEnMins(), resultDTO.getDuracionEstimadaEnMins());
    }
}