package com.mercadolibre.calculadorametroscuadrados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    private HouseDTO houseDTO;
    private RoomDTO roomDTO1;
    private RoomDTO roomDTO2;

    @BeforeEach
    void setUp() {
        roomDTO1 = new RoomDTO("main room", 50, 50);
        roomDTO2 = new RoomDTO("second room", 65, 50);

        houseDTO = new HouseDTO("house", "street 93", List.of(roomDTO1, roomDTO2));
    }

    @Test
    @DisplayName("Calculate price from house successful")
     void testCalculatePriceHouseSuccessful() {
        // Arrange
        int valueExpected = 2000000;
        houseDTO.setRooms(List.of(roomDTO1));

        // Act
        HouseResponseDTO response = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(valueExpected, response.getPrice());
    }

    @Test
    @DisplayName("Calculate dimension biggest from house")
     void testCalculateDimensionBiggest() {
        // Act
        HouseResponseDTO response = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(roomDTO2, response.getBiggest());
    }

    @Test
    @DisplayName("Calculate square meter from main room")
     void testCalculateSquareMeterRoomSuccessful() {
        // Arrange
        int squareMeterExpected = 2500;

        // Act
        Integer response = roomDTO1.getSquareFeet();

        // Assert
        assertEquals(squareMeterExpected, response);
    }
}
