package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.EntitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {


    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    @DisplayName("Calcular el valor de la casa")
    void calcularValorDeLaCasa() {
        // Arrange
        HouseDTO houseDTO = EntitiesTest.casaTest();
        HouseResponseDTO responseDTO = new HouseResponseDTO(houseDTO);
        responseDTO.setBiggest(houseDTO.getRooms().get(0));
        responseDTO.setPrice(32800);
        responseDTO.setSquareFeet(41);

        // Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        // Assert
        Assertions.assertEquals(responseDTO.getSquareFeet(), result.getSquareFeet());
        Assertions.assertEquals(responseDTO.getBiggest(), result.getBiggest());
        Assertions.assertEquals(responseDTO.getPrice(), result.getPrice());
    }

}
