package com.mercadolibre.calculadorametroscuadrados.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraMetrosCuadradosTest {
  CalculateService calculateService;

  @BeforeEach
  void setUp() {
    calculateService = new CalculateService();
  }

  @Test
  @DisplayName("Calculate the square feet and price of a house with four rooms")
  void calculateHouseWithFourRooms() {
   // Arrange
    HouseDTO house = new HouseDTO();
    house.setName("Casa");
    house.setAddress("Monroe 800");
    house.setRooms(
        List.of(
            new RoomDTO("Sala", 3, 3), // square feet = 9
            new RoomDTO("Cocina", 4, 2), // square feet = 8
            new RoomDTO("Baño", 2, 1), // square feet = 2
            new RoomDTO("Dormitorio", 4, 4) // square feet = 16
        )
    );

    HouseResponseDTO expectedResponse = new HouseResponseDTO();
    expectedResponse.setBiggest(new RoomDTO("Dormitorio", 4, 4));
    expectedResponse.setSquareFeet(35);
    expectedResponse.setPrice(800 * 35);

    // Act
    HouseResponseDTO response = calculateService.calculate(house);

    // Assert
    assertEquals(expectedResponse, response);
  }


}
