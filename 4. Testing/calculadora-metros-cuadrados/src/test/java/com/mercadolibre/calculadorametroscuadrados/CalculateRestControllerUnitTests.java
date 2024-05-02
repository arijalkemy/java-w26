package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerUnitTests {
    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

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
    public void squareFeetPriceAndBiggestAreCorrectlyCalculated(){
        //Arrange
        HouseResponseDTO expectedHouseResponseDTO = new HouseResponseDTO(houseDTO);
        expectedHouseResponseDTO.setBiggest(largestRoomDTO);
        expectedHouseResponseDTO.setSquareFeet(largestRoomDTO.getSquareFeet() + smallestRoomDTO.getSquareFeet());
        expectedHouseResponseDTO.setPrice(expectedHouseResponseDTO.getSquareFeet() * 800);

        //Act
        HouseResponseDTO obtained = calculateRestController.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expectedHouseResponseDTO.getBiggest(), obtained.getBiggest());
        Assertions.assertEquals(expectedHouseResponseDTO.getSquareFeet(), obtained.getSquareFeet());
        Assertions.assertEquals(expectedHouseResponseDTO.getPrice(), obtained.getPrice());
    }
}
