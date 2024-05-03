package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTest {
    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    @DisplayName("Test with rooms distinct of null")
    public void calculatePriceByMeterSquare() {
        HouseDTO request = HouseDTO
                .builder()
                .name("Chico norte")
                .address("Calle 95 #32 21")
                .rooms(List.of(
                        RoomDTO.builder()
                                .name("habitacion Principal")
                                .width(10)
                                .length(12)
                                .build(),
                        RoomDTO.builder()
                                .name("habitacion invitados")
                                .width(5)
                                .length(6)
                                .build(),
                        RoomDTO.builder()
                                .name("cuarto de aseo")
                                .width(5)
                                .length(5)
                                .build()
                ))
                .build();
        HouseResponseDTO expected = HouseResponseDTO
                .builder()
                .price(140000)
                .squareFeet(175)
                .biggest(RoomDTO.builder()
                        .length(12)
                        .name("habitacion Principal")
                        .width(10)
                        .build())
                .build();

        HouseResponseDTO actual = calculateService.calculate(request);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test with rooms equals of null")
    public void calculatePriceByMeterSquareNull() {
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

        HouseResponseDTO actual = calculateService.calculate(request);

        Assertions.assertEquals(expected, actual);
    }
}
