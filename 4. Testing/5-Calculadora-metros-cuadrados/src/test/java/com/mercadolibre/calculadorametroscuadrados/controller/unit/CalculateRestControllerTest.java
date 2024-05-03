package com.mercadolibre.calculadorametroscuadrados.controller.unit;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CalculateRestControllerTest {
    @Autowired
    CalculateRestController calculateRestController;

    @Test
    @DisplayName("Should calculate house price with one room")
    void shouldCalculateHouseValueWithOneRoom() {
        List<RoomDTO> rooms = TestUtils.roomsBuilder(1);
        HouseDTO house = TestUtils.createHouseDTO(rooms);

        HouseResponseDTO expectedHouseResponse = new HouseResponseDTO(house);
        expectedHouseResponse.setBiggest(rooms.get(0));
        expectedHouseResponse.setSquareFeet(TestUtils.calculateTotalSquareFeet(rooms));
        expectedHouseResponse.setPrice(TestUtils.calculateTotalSquareFeet(rooms) * TestUtils.squareFeetPrice);

        HouseResponseDTO actualHouseResponse = calculateRestController.calculate(house);

        Assertions.assertEquals(actualHouseResponse, expectedHouseResponse);
    }

    @Test
    @DisplayName("Should calculate house price with more than one room")
    void shouldCalculateHouseValueWithMoreThanOneRoom() {
        List<RoomDTO> rooms = TestUtils.roomsBuilder(2);
        HouseDTO house = TestUtils.createHouseDTO(rooms);

        HouseResponseDTO expectedHouseResponse = new HouseResponseDTO(house);
        expectedHouseResponse.setBiggest(rooms.get(rooms.size()- 1));

        Integer totalSquareFeet = TestUtils.calculateTotalSquareFeet(rooms);
        expectedHouseResponse.setSquareFeet(totalSquareFeet);
        expectedHouseResponse.setPrice(totalSquareFeet * TestUtils.squareFeetPrice);

        HouseResponseDTO actualHouseResponse = calculateRestController.calculate(house);

        Assertions.assertEquals(expectedHouseResponse, actualHouseResponse);
    }

    @Test
    @DisplayName("Should calculate biggest room correctly")
    void theBiggestRoomShouldbeTheOneExpected() {
        List<RoomDTO> rooms = TestUtils.roomsBuilder(2);
        HouseDTO house = TestUtils.createHouseDTO(rooms);

        RoomDTO biggest = rooms.get(rooms.size()- 1);

        HouseResponseDTO actualHouse = calculateRestController.calculate(house);

        Assertions.assertEquals(biggest, actualHouse.getBiggest());

    }

    @Test
    @DisplayName("Should calculate square feet correctly")
    void shouldCalculateSquareFeetCorrectly() {
        List<RoomDTO> rooms = TestUtils.roomsBuilder(3);
        HouseDTO house = TestUtils.createHouseDTO(rooms);
        Integer expectedSquareFeet = TestUtils.calculateTotalSquareFeet(rooms);

        HouseResponseDTO actualHouse = calculateRestController.calculate(house);

        Assertions.assertEquals(expectedSquareFeet, actualHouse.getSquareFeet());
    }

    @Test
    @DisplayName("Should throw exception with null house")
    void shouldThrowExceptionWithNullHouse() {
        Assertions.assertThrows(NullPointerException.class, () -> calculateRestController.calculate(null));
    }

    @Test
    @DisplayName("Should throw exception with null rooms")
    void shouldThrowExceptionWithNullRooms() {
        HouseDTO house = TestUtils.createHouseDTO(null);
        Assertions.assertThrows(NullPointerException.class, () -> calculateRestController.calculate(house));
    }

    @Test
    @DisplayName("Should handle house with no rooms")
    void shouldHandleHouseWithNoRooms() {
        HouseDTO house = TestUtils.createHouseDTO(new ArrayList<>());

        HouseResponseDTO expectedHouse = new HouseResponseDTO(house);
        expectedHouse.setSquareFeet(0);
        expectedHouse.setPrice(0);

        HouseResponseDTO actualHouse = calculateRestController.calculate(house);

        Assertions.assertNull(actualHouse.getBiggest());
        Assertions.assertEquals(0, actualHouse.getPrice());
        Assertions.assertEquals(0, actualHouse.getSquareFeet());
    }
}
