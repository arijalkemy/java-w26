package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestHouseGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @DisplayName("Integration Test - Calcular Datos de la casa con un solo cuarto")
    @Test
    void calculateHouseWithOneRoom() throws Exception {
        // Arrange
        HouseDTO house = TestHouseGenerator.getHouseDTOWithRooms();
        house.getRooms().remove(1);
        house.getRooms().remove(1);
        HouseResponseDTO houseResponseDTO = TestHouseGenerator.getHouseResponseDTOWithRooms();
        houseResponseDTO.getRooms().remove(1);
        houseResponseDTO.getRooms().remove(1);
        houseResponseDTO.setPrice(20000);
        houseResponseDTO.setSquareFeet(25);
        String request = writer.writeValueAsString(house);
        String houseExpected = writer.writeValueAsString(houseResponseDTO);
        // Act
        ResultActions response = this.mockMvc.perform(
                post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        // Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                            houseExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }

    @DisplayName("Integration Test - Calcular Datos de la casa con tres cuartos")
    @Test
    void calculateHouseWithMultipleRoom() throws Exception {
        // Arrange
        HouseDTO house = TestHouseGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = TestHouseGenerator.getHouseResponseDTOWithRooms();
        String request = writer.writeValueAsString(house);
        String houseExpected = writer.writeValueAsString(houseResponseDTO);
        // Act
        ResultActions response = this.mockMvc.perform(
                post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        // Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> assertEquals(
                                houseExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }

    @DisplayName("Integration Test - Calcular Datos de la casa con tres cuartos")
    @Test
    void calculateHouseWithoutRooms() throws Exception {
        // Arrange
        HouseDTO house = TestHouseGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTO = TestHouseGenerator.getHouseResponseDTOWithoutRooms();
        String request = writer.writeValueAsString(house);
        String houseExpected = writer.writeValueAsString(houseResponseDTO);
        // Act
        ResultActions response = this.mockMvc.perform(
                post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        // Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> assertEquals(
                                houseExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }

}
