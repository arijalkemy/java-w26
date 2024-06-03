package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtils.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.DisplayName;
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

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class IntegrationTests {

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Calculate - OK Test")
    public void calculateOKtest() throws Exception {
        //arrange
        HouseResponseDTO expectedResponse = makeHouseResponseDTO();
        HouseDTO bodyValue = makeHouseDTO();

        String jsonExpectedResponse = writer.writeValueAsString(expectedResponse);
        String jsonbodyValue = writer.writeValueAsString(bodyValue);

        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonbodyValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonExpectedResponse))
                .andReturn();
    }

    @Test
    @DisplayName("Check bigger room - OK Test")
    public void biggerRoomOKtest() throws Exception {
        //arrange
        String expectedResponse = "Living";
        HouseDTO bodyValue = makeHouseDTO();

        String jsonbodyValue = writer.writeValueAsString(bodyValue);

        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonbodyValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.biggest.name")
                        .value(expectedResponse))
                .andReturn();
    }

    @Test
    @DisplayName("Check price - OK Test")
    public void priceOKtest() throws Exception {
        //arrange
        Integer expectedResponse = 38400;
        HouseDTO bodyValue = makeHouseDTO();

        String jsonbodyValue = writer.writeValueAsString(bodyValue);

        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonbodyValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.price")
                        .value(expectedResponse))
                .andReturn();
    }

    @Test
    @DisplayName("Check sq ft - OK Test")
    public void squareFeetCalcOkTest() throws Exception {
        //arrange
        Integer expectedResponse = 48;
        HouseDTO bodyValue = makeHouseDTO();
        String jsonbodyValue = writer.writeValueAsString(bodyValue);

        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonbodyValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.squareFeet")
                        .value(expectedResponse))
                .andReturn();
    }

    @Test
    @DisplayName("Check sq ft per room - OK Test")
    public void squareFeetCalcPerRoomOkTest() throws Exception {
        //arrange
        Integer expectedResponse = 9;
        HouseDTO bodyValue = makeHouseDTO();
        String jsonbodyValue = writer.writeValueAsString(bodyValue);

        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonbodyValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.rooms[0].squareFeet")
                        .value(expectedResponse))
                .andReturn();
    }
}
