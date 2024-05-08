package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CalculateRestControllerTest {
    static CalculateRestController calculateRestController;

    @BeforeAll
    public static void setUp() {
        calculateRestController = new CalculateRestController();
    }

    @Test
    public void calculateOkTest() {
        // Arrange
        RoomDTO kitchen = new RoomDTO("Kitchen", 10, 10);
        RoomDTO bedroom = new RoomDTO("Bedroom", 5, 5);
        List<RoomDTO> roomDTOList = new ArrayList<>(){{
            add(kitchen);
            add(bedroom);
        }};
        HouseDTO houseDTO = new HouseDTO("Lakehouse", "Maple Road", roomDTOList);
        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(125);
        expected.setBiggest(kitchen);
        expected.setPrice(100000);

        // Act
        HouseResponseDTO response = calculateRestController.calculate(houseDTO);

        // Assert
        Assertions.assertEquals(expected, response);
    }
}
