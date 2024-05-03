package com.mercadolibre.calculadorametroscuadrados.service.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import utils.TestUtils;

import java.util.List;

@SpringBootTest
class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("Should calculate price correctly with one room")
    void shouldCalculatePriceCorrectlyWithOneRoom() {
        int numberOfRooms = 1;
        List<RoomDTO> rooms = TestUtils.roomsBuilder(numberOfRooms);
        HouseDTO house = TestUtils.createHouseDTO(rooms);
        Integer expectedPrice = TestUtils.calculateTotalSquareFeet(rooms) * TestUtils.squareFeetPrice;

        HouseResponseDTO actualHouse = calculateService.calculate(house);

        Assertions.assertEquals(expectedPrice, actualHouse.getPrice());
    }

    @Test
    @DisplayName("Should calculate price correctly with many rooms")
    void shouldCalculatePriceCorrectlyWithManyRooms() {
        int numberOfRooms = 5;
        List<RoomDTO> rooms = TestUtils.roomsBuilder(numberOfRooms);
        HouseDTO house = TestUtils.createHouseDTO(rooms);
        Integer expectedPrice = TestUtils.calculateTotalSquareFeet(rooms) * TestUtils.squareFeetPrice;

        HouseResponseDTO actualHouse = calculateService.calculate(house);

        Assertions.assertEquals(expectedPrice, actualHouse.getPrice());
    }

    @Test
    @DisplayName("Should calculate biggest room correctly")
    void shouldCalculateBiggestRoomCorrectly() {
        int numberOfRooms = 5;
        List<RoomDTO> rooms = TestUtils.roomsBuilder(numberOfRooms);
        HouseDTO house = TestUtils.createHouseDTO(rooms);
        RoomDTO expectedBiggestRoom = rooms.get(numberOfRooms - 1);

        HouseResponseDTO actualHouse = calculateService.calculate(house);

        Assertions.assertEquals(expectedBiggestRoom, actualHouse.getBiggest());
    }

    @Test
    @DisplayName("Should calculate total square feet correctly")
    void shouldCalculateTotalSquareFeetCorrectly() {
        int numberOfRooms = 5;
        List<RoomDTO> rooms = TestUtils.roomsBuilder(numberOfRooms);
        HouseDTO house = TestUtils.createHouseDTO(rooms);
        Integer expectedTotalSquareFeet = TestUtils.calculateTotalSquareFeet(rooms);

        HouseResponseDTO actualHouse = calculateService.calculate(house);

        Assertions.assertEquals(expectedTotalSquareFeet, actualHouse.getSquareFeet());
    }

    @Test
    @DisplayName("Should fail with null house")
    void shouldFailWIthNullHouse() {
        Assertions.assertThrows(NullPointerException.class, () -> calculateService.calculate(null));
    }

    @Test
    @DisplayName("Should fail with null rooms")
    void shouldFailWIthNullRooms() {
        HouseDTO house = TestUtils.createHouseDTO(null);
        Assertions.assertThrows(NullPointerException.class, () -> calculateService.calculate(house));
    }

    @Test
    @DisplayName("Should match expected object")
    void shouldMatchExpectedObject() {
        int numberOfRooms = 5;
        List<RoomDTO> rooms = TestUtils.roomsBuilder(numberOfRooms);
        HouseDTO house = TestUtils.createHouseDTO(rooms);

        HouseResponseDTO expectedHouse = new HouseResponseDTO(house);
        expectedHouse.setSquareFeet(TestUtils.calculateTotalSquareFeet(rooms));
        expectedHouse.setPrice(TestUtils.calculateTotalSquareFeet(rooms) * TestUtils.squareFeetPrice);
        expectedHouse.setBiggest(rooms.get(numberOfRooms - 1));

        HouseResponseDTO actualHouse = calculateService.calculate(house);

        Assertions.assertEquals(expectedHouse, actualHouse);
    }
}
