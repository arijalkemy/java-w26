package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.meli.obtenerdiploma.util.TestUtilsGenerator;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
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
    @DisplayName("Ok test for analyze scores")
    void analyzeScoresOk() throws Exception {
        // Given - Arrange
        StudentDTO expectedStudentDto = TestUtilsGenerator.getUserJsonRecord(1L);
        String expectedStudentStr = writer.writeValueAsString(expectedStudentDto);

        // When - Act
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String receivedStudentStr = result.getResponse().getContentAsString();

        // Then - Assert
        Assertions.assertEquals(expectedStudentStr, receivedStudentStr);
    }

    @Test
    @DisplayName("Error test for analyze scores with non-existent id")
    void analyzeScoresNotFound() throws Exception {
        // Given - Arrange
        Long invalidId = 99999L;
        ErrorDTO expectedError = new ErrorDTO("StudentNotFoundException", "El alumno con Id 99999 no se encuetra registrado.");
        String expectedErrorStr = writer.writeValueAsString(expectedError);

        // When - Act
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", invalidId)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        String receivedErrorStr = result.getResponse().getContentAsString();

        // Then - Assert
        Assertions.assertEquals(expectedErrorStr, receivedErrorStr);
    }

    @Test
    @DisplayName("Error test for analyze scores with wrong type id")
    void analyzeScoresError() throws Exception {
        // Given - Arrange
        String invalidId = "Sam";

        // When - Act
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", invalidId)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        // Then - Assert
    }
}
