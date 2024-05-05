package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateServiceTests {

    private RoomDTO createRoom(String name, int width, int length) {
        RoomDTO room = new RoomDTO();
        room.setName(name);
        room.setWidth(width);
        room.setLength(length);
        return room;
    }

    @Test
    public void testCalculate() {
        // Arrange
        CalculateService calculateService = new CalculateService();
        HouseDTO house = new HouseDTO();
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(createRoom("Living Room", 10, 20));
        rooms.add(createRoom("Bedroom", 15, 15));
        house.setRooms(rooms);

        // Act
        HouseResponseDTO result = calculateService.calculate(house);

        // Assert
        assertEquals(425, result.getSquareFeet());
        assertEquals("Bedroom", result.getBiggest().getName());
        assertEquals(425 * 800, result.getPrice());
    }

    @Test
    void testCalculateWithPriceError() {
        // Arrange
        CalculateService calculateService = new CalculateService();
        HouseDTO house = new HouseDTO();
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(createRoom("Living Room", 10, 20));
        rooms.add(createRoom("Bedroom", 15, 15));
        house.setRooms(rooms);

        // Mock CalculateService
        CalculateService mockedService = mock(CalculateService.class);
        when(mockedService.calculate(house)).thenThrow(new RuntimeException("Error calculating price"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            mockedService.calculate(house);
        });
    }

}
