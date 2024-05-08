package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestUtilGenerator;
import org.junit.jupiter.api.*;

import java.util.List;

public class CalculateServiceTests {
    private CalculateService service;

    @BeforeEach
    public void setUp(){
        this.service = new CalculateService();
    }

    @Test
    @DisplayName("Valida que el cuarto más grande sea el correcto")
    public void getBiggestRoomTest(){
        //Arrange
        HouseDTO house = TestUtilGenerator.getHouseWith3Rooms("Miguel G","Av 123");
        RoomDTO roomExpected = TestUtilGenerator.calculateBiggestRoom(house);
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);
        //Act
        service.calculateRoomSquareFeet(house,houseResponseDTO);
        //Assert
        Assertions.assertEquals(roomExpected,houseResponseDTO.getBiggest());
    }

    @Test
    @DisplayName("Valida que el precio de una propiedad con un cuarto sea el correcto")
    public void getPriceProperty1RoomsTest(){
        //Arrange
        HouseDTO house = TestUtilGenerator.getHouseWith1Room("Miguel G","Av 123");
        HouseResponseDTO houseDTO = new HouseResponseDTO(house);
        houseDTO.setPrice(TestUtilGenerator.calculatePriceProperty(house));
        //Act
        HouseResponseDTO houseResponseDTO = service.calculate(house);
        //Assert
        Assertions.assertEquals(houseDTO.getPrice(),houseResponseDTO.getPrice());
    }

    @Test
    @DisplayName("Valida que el precio de una propiedad con tres cuartos sea el correcto")
    public void getPriceProperty3RoomsTest(){
        //Arrange
        HouseDTO house = TestUtilGenerator.getHouseWith3Rooms("Miguel G","Av 123");
        HouseResponseDTO houseDTO = new HouseResponseDTO(house);
        houseDTO.setPrice(TestUtilGenerator.calculatePriceProperty(house));
        //Act
        HouseResponseDTO houseResponseDTO = service.calculate(house);
        //Assert
        Assertions.assertEquals(houseDTO.getPrice(),houseResponseDTO.getPrice());
    }

    @Test
    @DisplayName("Valida que el cuarto contenga las medidas correctas")
    public void calculateSuccessfulTest(){
        //Arrange
        HouseDTO house = TestUtilGenerator.getHouseWith3Rooms("Miguel G","Av 123");
        List<RoomDTO> squareFeetByRoom = TestUtilGenerator.calculateSquareFeetByRoom(house);
        //Act
        HouseResponseDTO houseResponseDTO = service.calculate(house);
        //Assert
        Assertions.assertEquals(squareFeetByRoom, houseResponseDTO.getRooms());
    }

}
