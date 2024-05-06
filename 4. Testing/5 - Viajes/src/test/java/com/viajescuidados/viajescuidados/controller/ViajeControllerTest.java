package com.viajescuidados.viajescuidados.controller;

import com.viajescuidados.controllers.ViajesController;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.services.ViajesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ViajeControllerTest {

    @Mock
    ViajesService service;

    @InjectMocks
    ViajesController controller;

    @Test
    public void crearViajeTestOk(){
        // arrange
        ViajeResponseDTO viajeResponseDTO = ViajeResponseDTO.builder()
                                            .id(1)
                                            .personaId(1)
                                            .cuidadores(new ArrayList<>())
                                            .origen(new UbicacionDTO("Siempre Viva 123", 123L, 456L))
                                            .destino(new UbicacionDTO("Marchini 6787", 789L, 123L))
                                            .estado("Viajando")
                                            .duracionEstimadaEnMins(60L)
                                            .fechaComienzo(LocalDateTime.now())
                                            .fechaFinalizacion(LocalDateTime.now())
                                            .build();

        int id = 1;

        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(new ArrayList<>())
                .origen(new UbicacionDTO("Siempre Viva 123", 123L, 456L))
                .destino(new UbicacionDTO("Marchini 6787", 789L, 123L))
                .build();

        // act
        when(service.crearViaje(viajeDTO, id)).thenReturn(viajeResponseDTO);
        ResponseEntity<?> result = controller.agregarViaje(viajeDTO, id);
        // assert
        Assertions.assertEquals(viajeResponseDTO.toString(), result.getBody().toString());
    }

    @Test
    public void comenzarViajeTestOk(){
        // arrange
        ViajeResponseDTO viajeResponseDTO = ViajeResponseDTO.builder()
                                            .id(1)
                                            .personaId(1)
                                            .cuidadores(new ArrayList<>())
                                            .origen(new UbicacionDTO("Siempre Viva 123", 123L, 456L))
                                            .destino(new UbicacionDTO("Marchini 6787", 789L, 123L))
                                            .estado("Viajando")
                                            .duracionEstimadaEnMins(60L)
                                            .fechaComienzo(LocalDateTime.now())
                                            .fechaFinalizacion(LocalDateTime.now())
                                            .build();
        int id = 1;
        // act
        when(service.comenzarViaje(id)).thenReturn(viajeResponseDTO);
        ResponseEntity<?> result = controller.comenzarViaje(id);
        // assert
        Assertions.assertEquals(viajeResponseDTO.toString(), result.getBody().toString());
    }
}
