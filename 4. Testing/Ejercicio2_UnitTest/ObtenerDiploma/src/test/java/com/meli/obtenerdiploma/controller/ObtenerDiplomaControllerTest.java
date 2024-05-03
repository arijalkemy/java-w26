package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentGeneratorTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ObtenerDiplomaController.class)
class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IObtenerDiplomaService service;

    private ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @Test
    void analyzeScores() throws Exception {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        String diplomaEsperado = "El alumno " + student.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(5.5) + ". Puedes mejorar.";
        student.setMessage(diplomaEsperado);
        student.setAverageScore(5.5);
        when(service.analyzeScores(student.getId())).thenReturn(student);
        String studentExpected = writer.writeValueAsString(student);
        // Act
        ResultActions response = mockMvc.perform(get("/analyzeScores/{studentId}", student.getId()));

        // Assert
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> assertEquals(
                                studentExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }
}