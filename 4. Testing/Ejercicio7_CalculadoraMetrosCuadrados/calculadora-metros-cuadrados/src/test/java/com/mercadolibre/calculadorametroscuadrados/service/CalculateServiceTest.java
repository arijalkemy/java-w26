package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestHouseGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @DisplayName("Test - Servicio de calcular con 3 cuartos")
    @Test
    void calculateWithRooms() {
        // Arrange
        HouseDTO house = TestHouseGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseExpected = TestHouseGenerator.getHouseResponseDTOWithRooms();
        // Act
        HouseResponseDTO houseObtained = calculateService.calculate(house);
        // Assert
        assertEquals(houseExpected, houseObtained);
    }

    @DisplayName("Test - Servicio de calcular sin cuartos")
    @Test
    void calculateWithoutRooms() {
        // Arrange
        HouseDTO house = TestHouseGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseExpected = TestHouseGenerator.getHouseResponseDTOWithoutRooms();
        // Act
        HouseResponseDTO houseObtained = calculateService.calculate(house);
        // Assert
        assertEquals(houseExpected, houseObtained);
    }
}