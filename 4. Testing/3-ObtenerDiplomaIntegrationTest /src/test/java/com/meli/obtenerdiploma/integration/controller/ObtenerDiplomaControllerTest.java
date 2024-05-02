package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void analyzeScores() throws Exception {
        long id = 1;
        StudentDTO student = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,
                Arrays.asList(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message" )
                        .value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore" )
                        .value(7.333333333333333))
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        String expectedResult = writer.writeValueAsString(student);

        Assertions.assertEquals(expectedResult, response);
    }

    @Test
    public void analyzeScoresInvalidUser() throws Exception {
        long id = 2;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description" )
                        .value("El alumno con Id " + id + " no se encuetra registrado.")).andReturn();
    }
}
