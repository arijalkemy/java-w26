package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    private RoomDTO roomTestA;
    private RoomDTO roomTestB;

    private HouseDTO houseTest;


    @BeforeEach
    void setUp() {

        roomTestA = new RoomDTO();
        roomTestA.setName("Room A");
        roomTestA.setWidth(15);
        roomTestA.setLength(25);

        roomTestB = new RoomDTO();
        roomTestB.setName("Room B");
        roomTestB.setWidth(10);
        roomTestB.setLength(25);

        houseTest = new HouseDTO();
        houseTest.setName("House A");
        houseTest.setAddress("Street A #40-56");
        houseTest.setRooms(List.of(roomTestA, roomTestB));

    }

    @Test
    @DisplayName("se verifica toda la salida esperada")
    void calculateWithAllDataTest() {
        //arrange
        HouseResponseDTO responseHouseTest = new HouseResponseDTO();
        responseHouseTest.setName("House A");
        responseHouseTest.setAddress("Street A #40-56");
        responseHouseTest.setRooms(List.of(roomTestA, roomTestB));

        responseHouseTest.setPrice(500000);
        responseHouseTest.setSquareFeet(625);
        responseHouseTest.setBiggest(roomTestA);

        when(calculateService.calculate(houseTest)).thenReturn(responseHouseTest);

        //act
        HouseResponseDTO response = calculateRestController.calculate(houseTest);

        //assert
        Assertions.assertEquals(response.getName(), responseHouseTest.getName());
        Assertions.assertEquals(response.getAddress(), responseHouseTest.getAddress());
        Assertions.assertEquals(response.getRooms().size(), responseHouseTest.getRooms().size());
        Assertions.assertEquals(response.getRooms(), responseHouseTest.getRooms());
        Assertions.assertEquals(response.getPrice(), responseHouseTest.getPrice());
        Assertions.assertEquals(response.getSquareFeet(), responseHouseTest.getSquareFeet());
    }

    @Test
    @DisplayName("Se verifica la salida esperada para el caso sin habitaciones")
    void calculateWithoutRoomsTest() {
        //arrange
        HouseResponseDTO responseHouseTest = new HouseResponseDTO();
        responseHouseTest.setRooms(List.of());

        responseHouseTest.setPrice(0);
        responseHouseTest.setSquareFeet(0);
        responseHouseTest.setBiggest(null);

        when(calculateService.calculate(houseTest)).thenReturn(responseHouseTest);

        //act
        HouseResponseDTO response = calculateRestController.calculate(houseTest);

        //assert
        Assertions.assertEquals(0, responseHouseTest.getRooms().size());
        Assertions.assertEquals(List.of() , responseHouseTest.getRooms());
        Assertions.assertEquals(0 , responseHouseTest.getPrice());
        Assertions.assertEquals(0 , responseHouseTest.getSquareFeet());
    }
}