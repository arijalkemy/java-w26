package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private String requestWithSingleRoom;
    private String requestWithMultipleRooms;

    @BeforeEach
    public void setUp() {
        requestWithSingleRoom = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom("Espacio abierto", 3, 3) +
                "]}";

        requestWithMultipleRooms = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom("Espacio abierto", 5, 5) + "," +
                getRoom("Cocina", 3, 3)  + "," +
                getRoom("Baño", 2, 1) +
                "]}";
    }

    @Test
    @DisplayName("Test calculate house with one room")
    void calculateHouseWithOneRoom() throws Exception {
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestWithSingleRoom))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("9")));
    }

    @Test
    @DisplayName("Test calculate house with multiple rooms")
    void calculateHouseWithMultipleRoom() throws Exception {
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestWithMultipleRooms))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("36")));
    }

    @Test
    @DisplayName("Test calculate house price")
    void calculateHousePrice() throws Exception {
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestWithMultipleRooms))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("36")))
                .andExpect(jsonPath("$.price").value(28800));
    }

    @Test
    @DisplayName("Test calculate biggest room")
    void calculateBiggestRoom() throws Exception {
        String biggestRoom = "Espacio abierto";
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestWithMultipleRooms))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest.name").value(biggestRoom));
    }

    @Test
    @DisplayName("Test calculate rooms square feet")
    void calculateRoomsSquareFeet() throws Exception {
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestWithMultipleRooms))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(9))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(2));
    }

    private String getRoom(String name, int width, int length) {
        return "{\"name\": \""+name+"\", \"width\": "+width+", \"length\": "+length+"}";
    }
}
