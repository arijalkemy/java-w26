package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    @Test
    @DisplayName("Should calculate the square meters of a house")
    void calculate() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa 1");
        houseDTO.setAddress("Calle 1");
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Habitacion 1");
        roomDTO.setWidth(10);
        roomDTO.setLength(10);
        houseDTO.setRooms(List.of(roomDTO));

        CalculateService calculateService = new CalculateService();
        HouseResponseDTO responseDTO = calculateService.calculate(houseDTO);

        assertEquals("Casa 1", responseDTO.getName());
        assertEquals(100, responseDTO.getSquareFeet());
        assertEquals(80000, responseDTO.getPrice());
    }
}