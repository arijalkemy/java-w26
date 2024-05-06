package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.GenerateHouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CalculateRestIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private ObjectWriter writer;

    private HouseDTO house;
    private HouseResponseDTO expectedResponse;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        house = GenerateHouse.generateHouse();
        expectedResponse = new HouseResponseDTO(house);
    }

    @Test
    public void calculatesTotalHousePrice() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("50400"));
    }

    @Test
    public void calculatesTotalHouseSquareFeet() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value("63"));
    }

    @Test
    public void identifiesBiggestRoom() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.name").value("Living room"));
    }

    @Test
    public void calculatesTotalHouseWithoutRoomsPrice() throws Exception {
        house = GenerateHouse.generateHouseWithoutRooms();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("0"));
    }

    @Test
    public void calculatesTotalHouseWithoutRoomsSquareFeet() throws Exception {
        house = GenerateHouse.generateHouseWithoutRooms();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value("0"));
    }

    @Test
    public void identifiesBiggestRoomWithoutRooms() throws Exception {
        house = GenerateHouse.generateHouseWithoutRooms();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest").doesNotExist());
    }
}
