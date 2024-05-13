package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.UnitTest.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.Util.DataHouse;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.controller.CalculateRestController;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseResponseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.service.CalculateService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class calculateUnitTest {
    private CalculateRestController calculateRestController;

    @BeforeEach
    void setUp() {
        calculateRestController = new CalculateRestController();
    }

    @Test
    @DisplayName("Dado los datos de la casa se valida los resultados obtenidos")
    public void calculate() {
        //Arrange
        HouseDTO house = DataHouse.getHouseDto();
        HouseResponseDTO houseResponse = DataHouse.getHouseResponseDTO(house);
        //Act
        HouseResponseDTO houseObtained =   calculateRestController.calculate(house);
        //Assert
        Assertions.assertEquals(house.getRooms().get(2), houseObtained.getBiggest());
    }
}
