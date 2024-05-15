package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void calculateWithoutRoomsTest() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();
        houseDTO.setRooms(new ArrayList<RoomDTO>());
        HouseResponseDTO expectedResult = new HouseResponseDTO(0, 0, null, "Casa", "Calle 123", new ArrayList<RoomDTO>());

        // Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        // Assert
        assertEquals(result, expectedResult);
    }

    @Test
    public void calculateWithNullRoomsTest() {
        // Arrange
        HouseDTO houseDTO = TestUtils.createHouseDTO();
        houseDTO.setRooms(null);

        // Act & Assert
        assertThrows(NullPointerException.class,() -> {
           calculateRestController.calculate(houseDTO);
        });
    }
}
