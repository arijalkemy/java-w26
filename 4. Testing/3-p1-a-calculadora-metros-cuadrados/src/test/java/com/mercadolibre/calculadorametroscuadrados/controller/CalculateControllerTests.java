package com.mercadolibre.calculadorametroscuadrados.controller;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CalculateControllerTests {

    private CalculateRestController calculateRestController;

    @BeforeEach
    void setUp() {
        calculateRestController = new CalculateRestController();
    }

    @Test
    void calculateSquareFeetOkTest() {
        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("My House");
        houseDTO.setAddress("123 Main St");

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("My Room");
        roomDTO1.setLength(10);
        roomDTO1.setWidth(15);
        rooms.add(roomDTO1);
        houseDTO.setRooms(rooms);

        // Act
        HouseResponseDTO actualResponse = calculateRestController.calculate(houseDTO);

        // Assert
        assertEquals(150, actualResponse.getSquareFeet());
    }


    @Test
    void calculateWithEmptyRoomListTest() {
        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("My House");
        houseDTO.setAddress("123 Main St");

        // No se agregan habitaciones a la lista

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            calculateRestController.calculate(houseDTO);
        });
    }


}
