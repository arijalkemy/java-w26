package com.mercadolibre.calculadorametroscuadrados.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class CalculateServiceTest {

    private RoomDTO roomTestA;
    private RoomDTO roomTestB;

    private HouseDTO houseTest;

    private static ObjectWriter writer;

    private CalculateService service;

    @BeforeEach
    void setUp() {
        service = new CalculateService();

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

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Debería calcular los metros cuadrados de la casa correctamente")
    void calculateHouseSquareFeetTest() {
        //arrange
        Integer squareExpectedRoomA = roomTestA.getSquareFeet();
        Integer squareExpectedRoomB = roomTestB.getSquareFeet();

        Integer squareExpected = squareExpectedRoomA + squareExpectedRoomB;

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(squareExpected, houseResponseDTO.getSquareFeet());
    }


    @Test
    @DisplayName("El square feet debería ser exactamente el mismo que el de la unica habitacion de la casa")
    void calculateHouseSquareFeetWitOneRoomTest() {
        //arrange
        houseTest.setRooms(List.of(roomTestA));
        Integer squareExpectedRoomA = roomTestA.getSquareFeet();

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(squareExpectedRoomA, houseResponseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("El square feet calculado debe ser 0")
    void calculateHouseSquareFeetWithoutRoomsTest() {
        //arrange
        houseTest.setRooms(List.of());

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(0, houseResponseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("El  price debe ser el esperado")
    void calculateHousePriceTest() {
        //arrange
        Integer squareExpectedRoomA = roomTestA.getSquareFeet();
        Integer squareExpectedRoomB = roomTestB.getSquareFeet();

        Integer squareExpected = squareExpectedRoomA + squareExpectedRoomB;

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(squareExpected*800, houseResponseDTO.getPrice());
    }

    @Test
    @DisplayName("El  price debe ser el 0")
    void calculateHousePriceWithoutRoomsTest() {
        //arrange
        houseTest.setRooms(List.of());

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(0, houseResponseDTO.getPrice());
    }

    @Test
    void calculateHousePriceWithoutRooms2Test() {
        //arrange
        RoomDTO roomTestC = new RoomDTO();
        roomTestC.setName("Room C");
        roomTestC.setWidth(20);
        roomTestC.setLength(25);
        houseTest.setRooms(List.of(roomTestA, roomTestB, roomTestC));

        Integer squareExpectedRoomA = roomTestA.getSquareFeet();
        Integer squareExpectedRoomB = roomTestB.getSquareFeet();
        Integer squereExpectedRoomC = roomTestC.getSquareFeet();

        Integer squareExpected = squareExpectedRoomA + squareExpectedRoomB + squereExpectedRoomC;

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(squareExpected, houseResponseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("la habitación mas grande debe ser la c")
    void calculateRoomBiggestTest() {
        //arrange
        RoomDTO roomTestC = new RoomDTO();
        roomTestC.setName("Room C");
        roomTestC.setWidth(20);
        roomTestC.setLength(25);
        houseTest.setRooms(List.of(roomTestA, roomTestB, roomTestC));

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertEquals(roomTestC.getName(), houseResponseDTO.getBiggest().getName());
    }

    @Test
    @DisplayName("la habitación mas grande debe ser nulo")
    void calculateRoomBiggestWithoutRoomsTest() {
        //arrange
        houseTest.setRooms(List.of());

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseTest);

        //assert
        Assertions.assertNull(houseResponseDTO.getBiggest());
    }

}