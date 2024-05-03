package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void calculateIntegrationTest() throws Exception {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa");
        houseDTO.setAddress("Calle 123");
        houseDTO.setRooms(List.of(new RoomDTO("Habitacion", 10, 10)));

        HouseResponseDTO houseExpectedResponseDTO = new HouseResponseDTO();
        houseExpectedResponseDTO.setName("Casa");
        houseExpectedResponseDTO.setAddress("Calle 123");
        houseExpectedResponseDTO.setSquareFeet(100);
        houseExpectedResponseDTO.setPrice(80000);
        RoomDTO room = new RoomDTO("Habitacion", 10, 10);
        houseExpectedResponseDTO.setRooms(List.of(room));
        houseExpectedResponseDTO.setBiggest(room);

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(houseDTO))
        ).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals("application/json", mvcResult.getResponse().getContentType());
        assertEquals(writer.writeValueAsString(houseExpectedResponseDTO)
                , mvcResult.getResponse().getContentAsString());
    }
}