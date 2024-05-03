package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    private CalculateService service;
    @InjectMocks
    private CalculateRestController controller;

    @Test
    @DisplayName("test endpoint calculate meters square")
    public void testEndpointCalculateMeters() {
        HouseDTO request = HouseDTO
                .builder()
                .name("Chico norte")
                .address("Calle 95 #32 21")
                .rooms(List.of(
                        RoomDTO.builder()
                                .name("habitacion Principal")
                                .width(null)
                                .length(null)
                                .build(),
                        RoomDTO.builder()
                                .name("habitacion invitados")
                                .width(null)
                                .length(null)
                                .build()
                ))
                .build();
        HouseResponseDTO expected = HouseResponseDTO
                .builder()
                .price(0)
                .squareFeet(0)
                .biggest(RoomDTO.builder()
                        .length(null)
                        .name("habitacion Principal")
                        .width(null)
                        .build())
                .build();

        when(service.calculate(request)).thenReturn(expected);

        HouseResponseDTO actual = controller.calculate(request);

        Assertions.assertEquals(expected, actual);
    }
}
