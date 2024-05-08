package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    public void setup() {
        this.calculateService = new CalculateService();
    }

    @Test
    public void calculateTest() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();
        HouseResponseDTO expectedResult = TestUtils.createHouseResponseDTO();

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(result, expectedResult);
    }

    @Test
    public void calculatePriceCorrectly() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(result.getPrice(), 17600);
    }

    @Test
    public void calculateBiggestRoomCorrectly() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(result.getBiggest().getName(), "Comedor");
    }

    @Test
    public void calculateRoomSquareFeetCorrectly() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(result.getSquareFeet(), TestUtils.calculateHomeSquareFeet(houseDTO.getRooms()));
    }
}
