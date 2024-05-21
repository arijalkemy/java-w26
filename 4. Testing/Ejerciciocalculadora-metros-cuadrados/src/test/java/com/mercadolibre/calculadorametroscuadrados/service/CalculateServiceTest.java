package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {
    @Test
    public void testCalculate() {
        // Arrange
        RoomDTO room1 = new RoomDTO();
        room1.setWidth(2);
        room1.setLength(5);  // 2 * 5 = 10 square feet
        RoomDTO room2 = new RoomDTO();
        room2.setWidth(4);
        room2.setLength(5);  // 4 * 5 = 20 square feet
        HouseDTO house = new HouseDTO();
        house.setRooms(Arrays.asList(room1, room2));

        CalculateService calculateService = new CalculateService();

        // Act
        var result = calculateService.calculate(house);

        // Assert
        assertEquals(30, result.getSquareFeet());
        assertEquals(24000, result.getPrice());
        assertEquals(room2, result.getBiggest());
    }

}
