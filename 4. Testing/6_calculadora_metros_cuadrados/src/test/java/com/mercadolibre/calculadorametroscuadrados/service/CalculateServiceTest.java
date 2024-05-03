package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService;

    static HouseDTO house;

    @BeforeAll
    static void init(){
        CalculateServiceTest.house = new HouseDTO();

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
    }

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    void calculateHouseSQRFeet() {
        // arrange
        Integer expectedSQRFeet = 220;

        // act
        HouseResponseDTO response = this.calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(expectedSQRFeet, response.getSquareFeet());
    }

    @Test
    void calculatePrice() {
        // arrange
        Integer expectedPrice = 176000;

        // act
        HouseResponseDTO response = this.calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(expectedPrice, response.getPrice());
    }

    @Test
    void calculateBiggestRoom() {
        // arrange
        String biggestRoomName = "sala 2";

        // act
        HouseResponseDTO response = this.calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(biggestRoomName, response.getBiggest().getName());
    }

    @Test
    void calculateWithSomeInvalidRooms() {
        // arrange
        RoomDTO room1 = new RoomDTO();
        room1.setLength(null);
        room1.setWidth(10);
        room1.setName("sala 1");

        RoomDTO room2 = new RoomDTO();
        room2.setLength(20);
        room2.setWidth(6);
        room2.setName("sala 2");

        HouseDTO house = new HouseDTO();
        house.setName("Casita");
        house.setAddress("Malabia 123");
        house.setRooms(List.of(room1, room2));

        Integer expectedSQRFeet = 120;
        Integer expectedPrice = 96000;

        // act
        HouseResponseDTO response = this.calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(expectedSQRFeet, response.getSquareFeet());
        Assertions.assertEquals(expectedPrice, response.getPrice());
    }

    @Test
    void calculateRoomSQRFeet() {
        // arrange
        RoomDTO room1 = new RoomDTO();
        room1.setLength(10);
        room1.setWidth(10);
        room1.setName("sala 1");

        Integer expectedSQRFeet = 100;

        // act
        Integer roomCalculate = room1.getSquareFeet();

        // Assert
        Assertions.assertEquals(expectedSQRFeet, roomCalculate);
    }

    @Test
    void calculateWithoutRooms() {
        // arrange
        HouseDTO house = new HouseDTO();
        house.setName("Casita");
        house.setAddress("Malabia 123");
        house.setRooms(List.of());

        Integer expectedSQRFeet = 0;
        Integer expectedPrice = 0;

        // act
        HouseResponseDTO response = this.calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(expectedSQRFeet, response.getSquareFeet());
        Assertions.assertEquals(expectedPrice, response.getPrice());
    }

}