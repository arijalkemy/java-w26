package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateServiceTest {
    @Autowired
    public CalculateService service;

    @Test
    @DisplayName("Ok test para calcular una casa")
    void calculateTest() {
        // Given - Arrange
        int roomCount = 2;
        HouseDTO houseDTO = Utils.getRandomHouse(roomCount);
        HouseResponseDTO expectedResponse = new HouseResponseDTO(houseDTO);
        RoomDTO simpleRoom = Utils.getTestRoom();
        RoomDTO biggestRoom = Utils.getBiggestTestRoom();
        int expectedSqFeet = (roomCount * simpleRoom.getLength() * simpleRoom.getWidth()) +
                (biggestRoom.getLength() * biggestRoom.getWidth());
        expectedResponse.setPrice(expectedSqFeet * 800);
        expectedResponse.setSquareFeet(expectedSqFeet);
        expectedResponse.setBiggest(biggestRoom);
        // When - Act
        HouseResponseDTO responseDTO = service.calculate(houseDTO);
        // Then - Assert
        Assertions.assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }
}
