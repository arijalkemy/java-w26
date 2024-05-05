package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analyze scores controller successful")
    void analyzeScoresTest() {
        // arrange
        Long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(studentId);
        when(service.analyzeScores(studentId)).thenReturn(studentDTO);

        // act
        StudentDTO resultStudentDTO = obtenerDiplomaController.analyzeScores(studentId);

        // assert
        verify(service, atLeastOnce()).analyzeScores(studentId);
        assertEquals(studentDTO.getId(), resultStudentDTO.getId());
        assertEquals(studentDTO.getStudentName(), resultStudentDTO.getStudentName());
        assertEquals(studentDTO.getSubjects(), resultStudentDTO.getSubjects());
        assertEquals(studentDTO.getAverageScore(), resultStudentDTO.getAverageScore());
    }

    @Test
    @DisplayName("Analyze scores controller with exception student not found")
    void analyzeScoreTest_StudentNotFoundException() {
        // arrange
        Long studentId = 9999L;
        when(service.analyzeScores(studentId)).thenThrow(StudentNotFoundException.class);

        // act and assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(studentId));
        verify(service, atLeastOnce()).analyzeScores(studentId);
    }
}