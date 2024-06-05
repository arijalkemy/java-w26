package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.UnitTest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.Util.DataHouse;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseResponseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.service.CalculateService;

public class CalculateServiceUnitTest {
    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    @DisplayName("Test 0001 - Verifica la propiedad")
    void calculateHouse(){
        //Arrange
        HouseDTO house = DataHouse.getHouseDto();
        HouseResponseDTO houseResponse = DataHouse.getHouseResponseDTO(house);
        //Act
        HouseResponseDTO houseObtained =   calculateService.calculate(house);
        //Assert
        Assertions.assertEquals(houseResponse, houseObtained);
    }

    @Test
    @DisplayName("Test 0002 - Verifica el cálculo del valor de la propiedad")
    void calculatepriceHouse(){
        //Arrange
        HouseDTO house = DataHouse.getHouseDto();
        HouseResponseDTO houseResponse = DataHouse.getHouseResponseDTO(house);
        //Act
        HouseResponseDTO houseObtained =   calculateService.calculate(house);
        //Assert
        Assertions.assertEquals(84800, houseObtained.getPrice());
    }

    @Test
    @DisplayName("Test 0003 - Verifica el cálculo del valor de metros cuadrados de la propiedad")
    void calculateSquareFeetHouse(){
        //Arrange
        HouseDTO house = DataHouse.getHouseDto();
        HouseResponseDTO houseResponse = DataHouse.getHouseResponseDTO(house);
        //Act
        HouseResponseDTO houseObtained =   calculateService.calculate(house);
        //Assert
        Assertions.assertEquals(106, houseObtained.getSquareFeet());
    }

    @Test
    @DisplayName("Test 0004 - verifica la habitación más grande")
    void calculateBiggestFeetHouse(){
        //Arrange
        HouseDTO house = DataHouse.getHouseDto();
        HouseResponseDTO houseResponse = DataHouse.getHouseResponseDTO(house);
        //Act
        HouseResponseDTO houseObtained =   calculateService.calculate(house);
        //Assert
        Assertions.assertEquals(house.getRooms().get(2), houseObtained.getBiggest());
    }
}
