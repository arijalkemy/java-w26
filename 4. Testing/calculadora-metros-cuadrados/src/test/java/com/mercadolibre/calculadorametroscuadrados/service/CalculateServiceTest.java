package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.GenerateHouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    private CalculateService calculateService;

    @BeforeEach
    public void setUp(){
        calculateService = new CalculateService();
    }

    @Test
    public void calculatesTotalHousePrice() {
        HouseDTO house = GenerateHouse.generateHouse();

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(50400, response.getPrice());
    }

    @Test
    public void calculatesTotalHouseSquareFeet() {
        HouseDTO house = GenerateHouse.generateHouse();

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(63, response.getSquareFeet());
    }

    @Test
    public void identifiesBiggestRoom() {
        HouseDTO house = GenerateHouse.generateHouse();

        HouseResponseDTO response = calculateService.calculate(house);

        assertSame(house.getRooms().get(2), response.getBiggest());
    }

    @Test
    public void calculatesTotalHouseWithoutRoomsPrice() {
        HouseDTO house = GenerateHouse.generateHouseWithoutRooms();

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(0, response.getPrice());
    }

    @Test
    public void calculatesTotalHouseWithoutRoomsSquareFeet() {
        HouseDTO house = GenerateHouse.generateHouseWithoutRooms();

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(0, response.getSquareFeet());
    }

    @Test
    public void identifiesBiggestRoomWithoutRooms() {
        HouseDTO house = GenerateHouse.generateHouseWithoutRooms();

        HouseResponseDTO response = calculateService.calculate(house);

        assertSame(null, response.getBiggest());
    }
}
