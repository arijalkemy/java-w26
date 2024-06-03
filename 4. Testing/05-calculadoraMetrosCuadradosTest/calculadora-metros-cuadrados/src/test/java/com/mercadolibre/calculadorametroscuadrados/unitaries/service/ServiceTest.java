package com.mercadolibre.calculadorametroscuadrados.unitaries.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtils.*;

import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    CalculateService calculateService;

    @BeforeEach
    private void setUp(){
        this.calculateService = new CalculateService();
    }

    @Test
    public void calculateOKTest(){
        //arrange
        HouseResponseDTO expectedResponse = makeHouseResponseDTO();
        HouseDTO house = makeHouseDTO();

        //act
        HouseResponseDTO obtainedResponse = calculateService.calculate(house);

        //assert
        Assertions.assertEquals(expectedResponse, obtainedResponse);
    }

    @Test
    public void calculateNotOKTest(){
        //arrange
        HouseResponseDTO expectedResponse = makeHouseResponseDTO();
        expectedResponse.setPrice(123456);
        HouseDTO house = makeHouseDTO();

        //act
        HouseResponseDTO obtainedResponse = calculateService.calculate(house);

        //assert
        Assertions.assertNotEquals(expectedResponse, obtainedResponse);
    }
}
