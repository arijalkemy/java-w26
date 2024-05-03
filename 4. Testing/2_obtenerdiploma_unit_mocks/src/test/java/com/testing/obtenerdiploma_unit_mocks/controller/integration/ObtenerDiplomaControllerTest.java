package com.testing.obtenerdiploma_unit_mocks.controller.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoresOfKnownStudent() throws Exception {
        // Arrange
        Integer id = 1;

        // Act & Assert
        mockMvc
            .perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", id))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.studentName").value("Juan"))
            .andReturn();
    }

    @Test
    void analyzeScoresOfUnknownStudent() throws Exception {
        // Arrange
        Integer id = 100;

        // Act & Assert
        mockMvc
            .perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", id))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
            .andReturn();
    }

    @Test
    void analyzeScoresWithError() throws Exception {
        // Arrange
        String idString = "asd";

        // Act & Assert
        mockMvc
            .perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", idString))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.name").value("MethodArgumentTypeMismatchException"))
            .andReturn();
    }
}