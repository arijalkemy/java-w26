package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresOkTest() throws JsonProcessingException {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        StudentDTO expectedResult = TestUtilsGenerator.getStudentWithMessageAndAverageScore();

        // Act
        when(obtenerDiplomaService.analyzeScores(student.getId())).thenReturn(expectedResult);
        StudentDTO result = obtenerDiplomaController.analyzeScores(student.getId());

        // Assert
        verify(obtenerDiplomaService, atLeast(1)).analyzeScores(any());
        Assertions.assertEquals(expectedResult, result);
        Assertions.assertEquals(student.getId(), result.getId());
    }
}
