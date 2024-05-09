package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.StudentUtils;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        TestUtilsGenerator.emptyUsersFile();
        StudentUtils.createTestStudents().forEach(TestUtilsGenerator::appendNewStudent);
    }

    @AfterEach
    public void teardown() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void analyzeScoresHappyPath() throws Exception {

        long studentId = 1;

        StudentDTO expectedResponse = new StudentDTO(
            1L,
            "Juan",
            "El alumno Juan ha obtenido un promedio de 2.00. Puedes mejorar.",
            2.0,
            List.of(
                new SubjectDTO("Ingles", 4.0),
                new SubjectDTO("Lengua", 0.0)
            )
        );
        String expectedResponseJson = new ObjectMapper().writeValueAsString(expectedResponse);

        mockMvc
            .perform(get("/analyzeScores/{studentId}", studentId))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedResponseJson));
    }

    @Test
    public void analyzeScoresStudentNotFound() throws Exception {

        long studentId = 100;

        ErrorDTO expectedResponse = new ErrorDTO(
            StudentNotFoundException.class.getSimpleName(),
            "El alumno con Id %d no se encuetra registrado.".formatted(studentId)
        );
        String expectedResponseJson = new ObjectMapper().writeValueAsString(expectedResponse);

        mockMvc
            .perform(get("/analyzeScores/{studentId}", studentId))
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedResponseJson));
    }
}
