package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateRestControllerTest {

    @Autowired
    private CalculateRestController calculateRestController;

    @Test
    public void calculateTest() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();
        HouseResponseDTO expectedResult = TestUtils.createHouseResponseDTO();

        // Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        // Assert
        assertEquals(result, expectedResult);
    }
}
