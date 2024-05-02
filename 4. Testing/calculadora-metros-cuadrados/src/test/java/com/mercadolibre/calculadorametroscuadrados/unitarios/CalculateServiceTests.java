package com.mercadolibre.calculadorametroscuadrados.unitarios;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateServiceTests {

    CalculateService calculateService;
    HouseDTO houseDTO;
    List<RoomDTO> roomDTOList;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
        houseDTO = new HouseDTO();
        roomDTOList = new ArrayList<>();
    }

    @Test
    @DisplayName("se calcula el precio de una casa con 3 habitaciones, dando por la habitación más grande la Room 3")
    public void calculateHouseWithMultipleRoomsTest() {
        //Arrange
        RoomDTO roomDTOUno = new RoomDTO();
        roomDTOUno.setName("Room 1");
        roomDTOUno.setLength(10);
        roomDTOUno.setWidth(10);
        roomDTOList.add(roomDTOUno);

        RoomDTO roomDTODos = new RoomDTO();
        roomDTODos.setName("Room 2");
        roomDTODos.setLength(5);
        roomDTODos.setWidth(7);
        roomDTOList.add(roomDTODos);

        RoomDTO roomDTOTres = new RoomDTO();
        roomDTOTres.setName("Room 2");
        roomDTOTres.setLength(20);
        roomDTOTres.setWidth(11);
        roomDTOList.add(roomDTOTres);

        houseDTO.setName("Casa Test Dorado");
        houseDTO.setAddress("Calle 34 #15-45");
        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(houseDTO);
        houseResponseDTOExpected.setBiggest(roomDTOTres);
        houseResponseDTOExpected.setPrice(284000);
        houseResponseDTOExpected.setSquareFeet(355);

        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertTrue(new ReflectionEquals(houseResponseDTOExpected).matches(houseResponseDTO));
    }

    @Test
    @DisplayName("se calcula el precio de una casa con 0 habitaciones")
    public void calculateHouseWithoutRoomsTest() {
        //Arrange

        houseDTO.setName("Casa Test Dorado");
        houseDTO.setAddress("Calle 34 #15-45");
        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(houseDTO);
        houseResponseDTOExpected.setBiggest(null);
        houseResponseDTOExpected.setPrice(0);
        houseResponseDTOExpected.setSquareFeet(0);

        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertTrue(new ReflectionEquals(houseResponseDTOExpected).matches(houseResponseDTO));
    }

    @Test
    @DisplayName("se calcula el precio de una casa con 1 habitación")
    public void calculateHouseWithOneRoomTest() {
        //Arrange
        RoomDTO roomDTOUno = new RoomDTO();
        roomDTOUno.setName("Room 1");
        roomDTOUno.setLength(10);
        roomDTOUno.setWidth(10);
        roomDTOList.add(roomDTOUno);

        houseDTO.setName("Casa Test Dorado");
        houseDTO.setAddress("Calle 34 #15-45");
        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(houseDTO);
        houseResponseDTOExpected.setBiggest(roomDTOUno);
        houseResponseDTOExpected.setPrice(80000);
        houseResponseDTOExpected.setSquareFeet(100);

        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertTrue(new ReflectionEquals(houseResponseDTOExpected).matches(houseResponseDTO));
    }

    @Test
    @DisplayName("se calcula el precio de una casa null")
    public void calculateNullHouseTest() {
        //Arrange
        houseDTO = null;

        //Acct and Assert
        assertThrows(NullPointerException.class, () -> calculateService.calculate(houseDTO));
    }
}
