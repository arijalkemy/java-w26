package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    @Test
    void calculateWithOnlyOneRoom() {
        CalculateService calculateService = new CalculateService();

        HouseDTO inputHouseDTO = new HouseDTO();
        inputHouseDTO.setName("Casa 1");
        inputHouseDTO.setAddress("Calle 1");
        List<RoomDTO> rooms = new ArrayList<>();

        rooms.add(new RoomDTO("Sala", 10, 10));

        inputHouseDTO.setRooms(rooms);

        HouseResponseDTO houseExpectedDTO = new HouseResponseDTO();
        houseExpectedDTO.setName("Casa 1");
        houseExpectedDTO.setAddress("Calle 1");
        houseExpectedDTO.setSquareFeet(100);
        houseExpectedDTO.setPrice(80000);
        houseExpectedDTO.setRooms(List.of(new RoomDTO("Sala", 10, 10)));
        houseExpectedDTO.setBiggest(new RoomDTO("Sala", 10, 10));

        HouseResponseDTO houseResponseDTO = calculateService.calculate(inputHouseDTO);

        Assertions.assertEquals(houseExpectedDTO, houseResponseDTO);
    }

    @Test
    void calculateWithMultipleRooms() {
        CalculateService calculateService = new CalculateService();

        HouseDTO inputHouseDTO = new HouseDTO();
        inputHouseDTO.setName("Casa 1");
        inputHouseDTO.setAddress("Calle 1");
        List<RoomDTO> rooms = new ArrayList<>();

        rooms.add(new RoomDTO("Sala", 10, 10));
        rooms.add(new RoomDTO("Cocina", 5, 5));
        rooms.add(new RoomDTO("Baño", 2, 2));

        inputHouseDTO.setRooms(rooms);

        HouseResponseDTO houseExpectedDTO = new HouseResponseDTO();
        houseExpectedDTO.setName("Casa 1");
        houseExpectedDTO.setAddress("Calle 1");
        houseExpectedDTO.setSquareFeet(129);
        houseExpectedDTO.setPrice(129*800);
        houseExpectedDTO.setRooms(List.of(new RoomDTO("Sala", 10, 10),
                new RoomDTO("Cocina", 5, 5),
                new RoomDTO("Baño", 2, 2)
                )
        );
        houseExpectedDTO.setBiggest(new RoomDTO("Sala", 10, 10));

        HouseResponseDTO houseResponseDTO = calculateService.calculate(inputHouseDTO);

        Assertions.assertEquals(houseExpectedDTO, houseResponseDTO);
    }

    @Test
    void calculateWithEmptyRooms(){
        CalculateService calculateService = new CalculateService();

        HouseDTO inputHouseDTO = new HouseDTO();
        inputHouseDTO.setName("Casa 1");
        inputHouseDTO.setAddress("Calle 1");
        List<RoomDTO> rooms = new ArrayList<>();

        inputHouseDTO.setRooms(rooms);

        HouseResponseDTO houseExpectedDTO = new HouseResponseDTO();
        houseExpectedDTO.setName("Casa 1");
        houseExpectedDTO.setAddress("Calle 1");
        houseExpectedDTO.setSquareFeet(0);
        houseExpectedDTO.setPrice(0);
        houseExpectedDTO.setRooms(List.of());
        houseExpectedDTO.setBiggest(null);

        HouseResponseDTO houseResponseDTO = calculateService.calculate(inputHouseDTO);

        Assertions.assertEquals(houseExpectedDTO, houseResponseDTO);
    }
}

