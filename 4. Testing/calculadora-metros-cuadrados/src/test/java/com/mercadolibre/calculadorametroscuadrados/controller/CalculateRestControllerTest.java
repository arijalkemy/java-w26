package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateRestControllerTest {

    private final CalculateRestController calculateRestController = new CalculateRestController();

    @Test
    void calculateTest() {
        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House");
        houseDTO.setAddress("1");

        RoomDTO room = new RoomDTO();
        room.setLength(10);
        room.setWidth(10);
        room.setName("Room 1");

        houseDTO.setRooms(List.of(room));

        // Act & Assert
        Assertions.assertEquals(100, calculateRestController.calculate(houseDTO).getSquareFeet());
    }

    @Test
    void calculateWithEmptyRoomTest() {
        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House");
        houseDTO.setAddress("1");

        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            calculateRestController.calculate(houseDTO);
        });
    }
}