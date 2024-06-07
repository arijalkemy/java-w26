package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class VehicleControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    final ObjectWriter writer = new ObjectMapper().writer();

    @Test
    @DisplayName("Get vehicle by color and year ok test")
    void getVehiclesByColorAndYearOkTest() throws Exception {
        String color = "Mauv";
        int year = 2014;

        List<VehicleDto> expectedVehicles = Collections
                .singletonList(TestUtils.fordFiestaVehicleDto());

        String expectedResponseString = writer.writeValueAsString(expectedVehicles);

        MvcResult result = mockMvc
                .perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String actualResponseString = result.getResponse().getContentAsString();

        assertEquals(expectedResponseString, actualResponseString);
    }

    @Test
    @DisplayName("Get vehicle by color and year not found test")
    void getVehiclesByColorAndYearNotFoundTest() throws Exception {
        String color = "Color que no existe";
        int year = 2010;

        mockMvc
                .perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("No se encontraron vehículos con esos criterios."));
    }

    @Test
    @DisplayName("Get average speed by brand OK test")
    void getAverageSpeedByBrandOKTest() throws Exception{
        // Arrange
        String brand = "Lexus";
        VehicleAvgSpeedByBrandDto expectedResponseDTO = new VehicleAvgSpeedByBrandDto(150);
        String expectedResponse = writer.writeValueAsString(expectedResponseDTO);

        // Act
        MvcResult result = mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String actualResponse = result.getResponse().getContentAsString();

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get avg speed by brand not found test")
    void getAverageSpeedByBrandNotFoundTest() throws Exception {
        // Arrange
        String brand = "Marca que no existe";

        // Act & assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.message")
                        .value("No se encontraron vehículos de esa marca."));
    }

    @Test
    @DisplayName("Get average capacity by brand test")
    void getAverageCapacityByBrandTest() throws Exception {
        // Arrange
        String brand = "Lexus";
        VehicleAvgCapacityByBrandDto expectedResponseDto = new VehicleAvgCapacityByBrandDto(5.0);
        String expectedResponse = writer.writeValueAsString(expectedResponseDto);

        // Act
        MvcResult result = mockMvc
                .perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String actualResponse = result.getResponse().getContentAsString();

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("List by range of weight")
    void getVehiclesByRangeOfWeightOkTest() throws Exception {
        // Arrange
        String min = "200";
        String max = "400";
        List<VehicleDto> expectedVehicleDtos = Collections.singletonList(TestUtils.fordFiestaVehicleDto());
        String expectedString = writer.writeValueAsString(expectedVehicleDtos);

        // Act
        MvcResult result = mockMvc
                .perform(get("/vehicles/weight")
                        .param("min", min)
                        .param("max", max))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String actualString = result.getResponse().getContentAsString();

        // Assert
        assertEquals(expectedString, actualString);
    }
}
