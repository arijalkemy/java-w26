package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analyze Scores")
    public void analyzeScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO(); // Provide necessary data for expected student
        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudent);

        // Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        Assertions.assertEquals(expectedStudent, result);
    }


}
