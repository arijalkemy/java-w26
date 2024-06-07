package com.bootcampW22.EjercicioGlobal.utils.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class VehicleControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    final ObjectWriter writer = new ObjectMapper().writer();

    @Test
    @DisplayName("Get by weight range ok test")
    void getVehiclesByRangeOfWeightOkTest() throws Exception {
        // Arrange
        String minWeight = "200";
        String maxWeight = "300";
        List<VehicleDto> expectedVehicleDtos = new ArrayList<>();
        expectedVehicleDtos.add(TestUtils.fordFiestaVehicleDto());
        String expectedResponseBody = writer.writeValueAsString(expectedVehicleDtos);

        // Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/vehicles/weight")
                        .param("min", minWeight)
                        .param("max", maxWeight))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String actualResponse = result.getResponse().getContentAsString();
        // Assert
        Assertions.assertEquals(expectedResponseBody, actualResponse);
    }
}
