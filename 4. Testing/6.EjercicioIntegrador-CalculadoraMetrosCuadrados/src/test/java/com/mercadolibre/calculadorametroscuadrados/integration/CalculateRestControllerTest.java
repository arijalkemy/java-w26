package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private RoomDTO roomTestA;
    private RoomDTO roomTestB;

    private HouseDTO houseTest;

    private static ObjectWriter writer;

    @BeforeEach
    void setUp() {
        roomTestA = new RoomDTO();
        roomTestA.setName("Room A");
        roomTestA.setWidth(15);
        roomTestA.setLength(25);

        roomTestB = new RoomDTO();
        roomTestB.setName("Room B");
        roomTestB.setWidth(10);
        roomTestB.setLength(25);

        houseTest = new HouseDTO();
        houseTest.setName("House A");
        houseTest.setAddress("Street A #40-56");
        houseTest.setRooms(List.of(roomTestA, roomTestB));

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void CorrectCalculatedHousePriceTest() throws Exception {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setName("House A");
        houseResponseDTO.setAddress("Street A #40-56");
        houseResponseDTO.setRooms(List.of(roomTestA));
        houseResponseDTO.setBiggest(roomTestA);

        String houseJson =  writer.writeValueAsString(houseTest);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    void CorrectCalculatedBiggestRoomTest() throws Exception {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setName("House A");
        houseResponseDTO.setAddress("Street A #40-56");
        houseResponseDTO.setRooms(List.of(roomTestA));
        houseResponseDTO.setBiggest(roomTestA);

        String houseJson =  writer.writeValueAsString(houseTest);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(houseJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.rooms[0].name").value(roomTestA.getName()));

    }

}
