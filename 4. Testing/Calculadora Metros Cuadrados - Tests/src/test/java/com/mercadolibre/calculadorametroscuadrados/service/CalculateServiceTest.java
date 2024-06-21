package com.mercadolibre.calculadorametroscuadrados.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {
    @InjectMocks
    CalculateService service;

    ObjectWriter writer;
    HouseDTO house;
    HouseResponseDTO response;


    @BeforeEach
    public void setUp() {
        service = new CalculateService();
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Espacio abierto");
        room1.setWidth(5);
        room1.setLength(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Cocina");
        room2.setWidth(3);
        room2.setLength(3);

        RoomDTO room3 = new RoomDTO();
        room3.setName("Baño");
        room3.setWidth(2);
        room3.setLength(1);

// Crear una lista de objetos RoomDTO
        List<RoomDTO> rooms = Arrays.asList(room1, room2, room3);

// Crear un objeto HouseDTO
        house = new HouseDTO();
        house.setName("Oficina");
        house.setAddress("Monroe 800");
        house.setRooms(rooms);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        response = new HouseResponseDTO(house);
        response.setPrice(28800);
        response.setSquareFeet(36);
        response.setBiggest(room1);
    }

    @Test
    public void calculate() throws JsonProcessingException {
        HouseResponseDTO result = service.calculate(house);
        String payloadJSON = writer.writeValueAsString(response);
        String responseJSON = writer.writeValueAsString(result);
        assertEquals(payloadJSON, responseJSON);
    }

}
