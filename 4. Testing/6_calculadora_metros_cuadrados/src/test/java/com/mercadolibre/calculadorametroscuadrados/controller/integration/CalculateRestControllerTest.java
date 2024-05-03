package com.mercadolibre.calculadorametroscuadrados.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
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

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static HouseDTO house;
    private static HouseResponseDTO houseResponseDTO;
    private static ObjectMapper writer;


    @BeforeAll
    static void init(){
        CalculateRestControllerTest.house = new HouseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setLength(10);
        room1.setWidth(10);
        room1.setName("sala 1");

        RoomDTO room2 = new RoomDTO();
        room2.setLength(20);
        room2.setWidth(6);
        room2.setName("sala 2");

        house.setName("Casita");
        house.setAddress("Malabia 123");
        house.setRooms(List.of(room1, room2));

        CalculateRestControllerTest.houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setSquareFeet(220);
        houseResponseDTO.setPrice(176000);
        houseResponseDTO.setBiggest(room2);

        CalculateRestControllerTest.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false);

    }

    @Test
    void calculateCorrectSQRFeet() throws Exception {
        // Arrange
        String expectedObjectString = writer.writeValueAsString(houseResponseDTO);

        // Act
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expectedObjectString))
                .andReturn();

        String resultObject = result.getResponse().getContentAsString();
        System.out.println(resultObject);
        // Assert
        Assertions.assertEquals(expectedObjectString, resultObject);
    }
}