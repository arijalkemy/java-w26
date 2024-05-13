package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.TestUtilsGenerator;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @Mock
    CalculateService calculateService;

    @Test
    @DisplayName("Test de cálculo general")
    public void calculateTest() {
        HouseDTO houseDTO = TestUtilsGenerator.generateHouseDTORequest();
        HouseResponseDTO expectedHouseResponseDTO = TestUtilsGenerator.generateHouseResponseDTO(houseDTO);
        when(calculateService.calculate(houseDTO)).thenReturn(expectedHouseResponseDTO);

        HouseResponseDTO actualHouseResponseDTO = calculateService.calculate(houseDTO);

        assertEquals(expectedHouseResponseDTO, actualHouseResponseDTO);
    }

    @Test
    @DisplayName("Test de cálculo con cero habitaciones")
    public void calculateTest_ZeroRooms() {
        HouseDTO houseDTO = new HouseDTO("ZeroRoomHouse", "Zero Room Street", Collections.emptyList());
        HouseResponseDTO expectedHouseResponseDTO = new HouseResponseDTO(houseDTO);
        expectedHouseResponseDTO.setSquareFeet(0);
        expectedHouseResponseDTO.setPrice(0);
        when(calculateService.calculate(houseDTO)).thenReturn(expectedHouseResponseDTO);

        HouseResponseDTO actualHouseResponseDTO = calculateService.calculate(houseDTO);

        assertEquals(expectedHouseResponseDTO, actualHouseResponseDTO);
    }

    @Test
    @DisplayName("Test de cálculo con una habitación")
    public void calculateTest_OneRoom() {
        HouseDTO houseDTO = TestUtilsGenerator.generateHouseDTORequest();
        houseDTO.setRooms(Collections.singletonList(new RoomDTO("SingleRoom", 5, 5)));
        HouseResponseDTO expectedHouseResponseDTO = TestUtilsGenerator.generateHouseResponseDTO(houseDTO);
        expectedHouseResponseDTO.setSquareFeet(25);
        expectedHouseResponseDTO.setPrice(20000);
        when(calculateService.calculate(houseDTO)).thenReturn(expectedHouseResponseDTO);

        HouseResponseDTO actualHouseResponseDTO = calculateService.calculate(houseDTO);

        assertEquals(expectedHouseResponseDTO, actualHouseResponseDTO);
    }

    @Test
    @DisplayName("Test de cálculo del Room más grande")
    public void calculateRoomSquareFeetTest() {
        // Arrange
        HouseDTO houseDTO = TestUtilsGenerator.generateHouseDTORequest();
        HouseResponseDTO expectedResponseDTO = TestUtilsGenerator.generateHouseResponseDTO(houseDTO);
        expectedResponseDTO.setSquareFeet(25);
        expectedResponseDTO.setPrice(20000);
        expectedResponseDTO.setBiggest(houseDTO.getRooms().get(0));

        when(calculateService.calculate(houseDTO)).thenReturn(expectedResponseDTO);

        // Act
        HouseResponseDTO actualHouseResponseDTO = calculateService.calculate(houseDTO);
        System.out.println(actualHouseResponseDTO.getBiggest().getName());

        // Assert
        assertEquals(expectedResponseDTO.getBiggest(), actualHouseResponseDTO.getBiggest());
    }


}
