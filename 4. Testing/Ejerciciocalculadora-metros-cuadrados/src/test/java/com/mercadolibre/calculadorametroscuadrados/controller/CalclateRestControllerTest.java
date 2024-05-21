package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CalclateRestControllerTest {
    @Mock
    private CalculateService service;

    @InjectMocks
    private CalculateRestController controller;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCalculate() {
        // Arrange
        HouseDTO house = new HouseDTO();
        RoomDTO room = new RoomDTO();
        room.setWidth(2);
        room.setLength(5);
        house.setRooms(Collections.singletonList(room));

        HouseResponseDTO expectedResponse = new HouseResponseDTO();
        expectedResponse.setSquareFeet(10);
        expectedResponse.setPrice(8000);
        expectedResponse.setBiggest(room);

        when(service.calculate(any(HouseDTO.class))).thenReturn(expectedResponse);

        // Act
        HouseResponseDTO actualResponse = controller.calculate(house);

        // Assert
        assertEquals(expectedResponse.getSquareFeet(), actualResponse.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), actualResponse.getPrice());
        assertEquals(expectedResponse.getBiggest(), actualResponse.getBiggest());
    }
}
