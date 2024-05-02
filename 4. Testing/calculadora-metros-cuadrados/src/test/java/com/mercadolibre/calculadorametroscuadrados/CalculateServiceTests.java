package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTests {
    private CalculateService calculateService = new CalculateService();

    private HouseDTO houseDTO;
    private RoomDTO largestRoomDTO;
    private RoomDTO smallestRoomDTO;
    private RoomDTO emptyRoomDTO = new RoomDTO();

    @BeforeEach
    void setUp() {
        largestRoomDTO = new RoomDTO();
        largestRoomDTO.setLength(100);
        largestRoomDTO.setWidth(100);
        largestRoomDTO.setName("Largest Room");

        smallestRoomDTO = new RoomDTO();
        smallestRoomDTO.setLength(5);
        smallestRoomDTO.setWidth(5);
        smallestRoomDTO.setName("Smallest Room");

        houseDTO = new HouseDTO();
        houseDTO.setAddress("Av. Siempreviva 123");
        houseDTO.setName("Casa");
        houseDTO.setRooms(List.of(smallestRoomDTO, largestRoomDTO, emptyRoomDTO));
    }

    @Test
    public void priceIsCalculatedBySumOfRooms(){
        //Arrange
        HouseResponseDTO expectedPlaceholder = new HouseResponseDTO();
        expectedPlaceholder.setSquareFeet(largestRoomDTO.getSquareFeet() + smallestRoomDTO.getSquareFeet());
        expectedPlaceholder.setPrice(expectedPlaceholder.getSquareFeet()*800);

        //Act
        HouseResponseDTO obtained = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expectedPlaceholder.getPrice(), obtained.getPrice());
        Assertions.assertEquals(expectedPlaceholder.getSquareFeet(), obtained.getSquareFeet());
    }

    @Test
    public void biggestRoomIsCalculatedCorrectly(){
        //Arrange
        RoomDTO biggest = largestRoomDTO;

        //Act
        HouseResponseDTO obtained = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(biggest, obtained.getBiggest());
    }
}
