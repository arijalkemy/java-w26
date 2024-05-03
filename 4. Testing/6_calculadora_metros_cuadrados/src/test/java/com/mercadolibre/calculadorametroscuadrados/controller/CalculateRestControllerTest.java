package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class CalculateRestControllerTest {

    private CalculateRestController calculateRestController;

    private static HouseDTO house;
    private static HouseResponseDTO houseResponseDTO;

    @BeforeAll
    static void init(){
        CalculateRestControllerTest.house = new HouseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setLength(10);
        room1.setWidth(10);
        room1.setName("sala 1");

        RoomDTO room2 = new RoomDTO();
        room2.setLength(20);
        room2.setWidth(6);
        room2.setName("sala 2");

        house.setName("Casita");
        house.setAddress("Malabia 123");
        house.setRooms(List.of(room1, room2));

        CalculateRestControllerTest.houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setSquareFeet(220);
        houseResponseDTO.setPrice(176000);
        houseResponseDTO.setBiggest(room2);

    }

    @BeforeEach
    void setUp() {
        calculateRestController = new CalculateRestController();
    }


    @Test
    void calculateCorrectSQRFeet() {
        // Arrange
        Integer expectedSQR = houseResponseDTO.getSquareFeet();

        // Act
        Integer result = this.calculateRestController.calculate(house).getSquareFeet();

        // Assert
        Assertions.assertEquals(expectedSQR, result);
    }
}