package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceTest {
    CalculateService calculateService=new CalculateService();

    HouseDTO house= new HouseDTO();
    RoomDTO principal= new RoomDTO();
    RoomDTO studio = new RoomDTO();
    @BeforeEach
    void setup(){
        house.setName("Name");
        house.setAddress("False street 123");
        principal.setName("principal");
        principal.setLength(3);
        principal.setWidth(5);
        studio.setName("studio");
        studio.setLength(3);
        studio.setWidth(2);
        List<RoomDTO> rooms = List.of(
                studio,
                principal
        );
        house.setRooms(rooms);
    }

    @Test
    @DisplayName("Calculate house Response test")
    void calculateTest(){
        //Arrange
        HouseResponseDTO expectedResponse = new HouseResponseDTO();
        expectedResponse.setAddress("False Street 123");
        expectedResponse.setBiggest(principal);
        expectedResponse.setSquareFeet(21);
        expectedResponse.setRooms(List.of(principal,studio));
        expectedResponse.setName("Name");
        expectedResponse.setPrice(16800);
        //Act
        HouseResponseDTO result = calculateService.calculate(house);
        //Assert
        assertEquals(expectedResponse.toString(),result.toString());

    }
}
