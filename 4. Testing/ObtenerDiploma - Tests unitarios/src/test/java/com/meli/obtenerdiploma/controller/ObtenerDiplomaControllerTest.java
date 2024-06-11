package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.jayway.jsonpath.JsonPath;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentGenerator;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ObtenerDiplomaController.class)
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IObtenerDiplomaService service;


    private static ObjectWriter writer;


    private static StudentDTO student;


    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        student = StudentGenerator.generateStudent();

    }

    @Test
    @DisplayName("Test For Analyze Student Scores status 200")
    public void analyzeScoresTest() throws Exception {
//        Arrange
        String message = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(student.getAverageScore()) + ". Puedes Mejorar!";
        student.setMessage(message);
        when(service.analyzeScores(student.getId())).thenReturn(student);

        String studentString = writer.writeValueAsString(student);

//        Act & Assert
        mockMvc.perform(get("/analyzeScores/{studentId}", student.getId())
                .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(result -> assertEquals(
                            studentString, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                    ));

    }

    @Test
    @DisplayName("Test For Analyze Student Scores status 404")
    public void analyzeScoresTest404() throws Exception {
//        Arrange
        when(service.analyzeScores(100L)).thenThrow(StudentNotFoundException.class);

//        Act & Assert
        mockMvc.perform(get("/analyzeScores/{studentId}", 100L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }



}