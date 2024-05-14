package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.EntitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    @DisplayName("Se verifica el cálculo de la propiedad")
    void calcularValorPropiedad() {
        //Arrange
        HouseDTO houseDTO = EntitiesTest.casaTest();
        HouseResponseDTO houseResponseDTO;

        //Act
        houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(32800, houseResponseDTO.getPrice());
    }

    @Test
    @DisplayName("Se verifica el cálculo de los metros cuadrados de la propiedad")
    void calcularMtrsPorHabitacionPropiedad() {
        //Arrange
        HouseDTO houseDTO = EntitiesTest.casaTest();
        HouseResponseDTO houseResponseDTO;

        //Act
        houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(41, houseResponseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("Se verifica el cálculo de los metros cuadrados de la propiedad")
    void calcularMayorHabitacionPropiedad() {
        //Arrange
        HouseDTO houseDTO = EntitiesTest.casaTest();
        HouseResponseDTO houseResponseDTO;

        //Act
        houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(houseDTO.getRooms().get(0), houseResponseDTO.getBiggest());
    }

    @Test
    @DisplayName("Se verifica el error cuando la casa dto esta vacia")
    void calcularErrorPropiedad() {
        //Arrange
        HouseDTO houseDTO = new HouseDTO();

        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class, () ->  calculateService.calculate(houseDTO));
    }


}
