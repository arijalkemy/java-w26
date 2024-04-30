package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWith3Subjects("Juan"));
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Gabriel"));
    }

    @Test
    void testAnalyzeScoresSuccessResponse() throws Exception {
        StudentDTO expectedResponse = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        expectedResponse.setMessage("El alumno Juan ha obtenido un promedio de 6.00. Puedes mejorar.");
        expectedResponse.setAverageScore(6.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponseJson = writer.writeValueAsString(expectedResponse);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/9999"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), expectedResponseJson);
    }

    @Test
    void testAnalyzeScoresNotFoundResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/1"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 1 no se encuetra registrado."));
    }

    @Test
    void testAnalyzeScoresInvalidId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/e"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}

