package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.apache.catalina.startup.HomesUserDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTest {
    private CalculateService calculateService = new CalculateService();

    @Test
    void calculateOK() {
        RoomDTO room1 = new RoomDTO();
        room1.setLength(10);
        room1.setWidth(10);
        room1.setName("Sala");
        RoomDTO room2 = new RoomDTO();
        room2.setLength(5);
        room2.setWidth(5);
        room2.setName("Baño");
        HouseDTO house = new HouseDTO();
        house.setName("Casa 1");
        house.setAddress("Calle 1");
        house.setRooms(List.of(room1, room2));

        HouseResponseDTO response = new HouseResponseDTO();
        response.setName("Casa 1");
        response.setAddress("Calle 1");
        response.setRooms(List.of(room1, room2));
        response.setSquareFeet(125);
        response.setPrice(100000);
        response.setBiggest(room1);

        HouseResponseDTO result = calculateService.calculate(house);

        Assertions.assertEquals(response, result);
    }
}
