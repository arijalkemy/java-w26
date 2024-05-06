package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.GenerateHouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    HouseResponseDTO whenResponse;

    @BeforeEach
    public void setUp() {
        whenResponse = new HouseResponseDTO();
        when(calculateService.calculate(any(HouseDTO.class))).thenReturn(whenResponse);
    }

    @Test
    public void calculatesTotalHousePrice() {
        whenResponse.setPrice(50400);
        HouseDTO house = GenerateHouse.generateHouse();

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertEquals(50400, response.getPrice());
    }

    @Test
    public void calculatesTotalHouseSquareFeet() {
        whenResponse.setSquareFeet(63);
        HouseDTO house = GenerateHouse.generateHouse();

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertEquals(63, response.getSquareFeet());
    }

    @Test
    public void identifiesBiggestRoom() {
        HouseDTO house = GenerateHouse.generateHouse();
        whenResponse.setBiggest(house.getRooms().get(2));

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertSame(house.getRooms().get(2), response.getBiggest());
    }

    @Test
    public void calculatesTotalHouseWithoutRoomsPrice() {
        whenResponse.setPrice(0);
        HouseDTO house = GenerateHouse.generateHouseWithoutRooms();

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertEquals(0, response.getPrice());
    }

    @Test
    public void calculatesTotalHouseWithoutRoomsSquareFeet() {
        whenResponse.setSquareFeet(0);
        HouseDTO house = GenerateHouse.generateHouseWithoutRooms();

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertEquals(0, response.getSquareFeet());
    }

    @Test
    public void identifiesBiggestRoomWithoutRooms() {
        whenResponse.setBiggest(null);
        HouseDTO house = GenerateHouse.generateHouseWithoutRooms();

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertSame(null, response.getBiggest());
    }
}
