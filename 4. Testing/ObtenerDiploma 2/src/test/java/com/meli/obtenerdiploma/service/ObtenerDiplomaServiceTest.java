package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze Scores Successful")
    void analyzeScoresSuccessfulTest() {
        // arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // act
        StudentDTO resultStudentDTO = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO.getStudentName(), resultStudentDTO.getStudentName());
        Assertions.assertEquals(studentDTO.getId(), resultStudentDTO.getId());
        Assertions.assertEquals(studentDTO.getSubjects(), resultStudentDTO.getSubjects());
    }

    @Test
    @DisplayName("Student not found to analyze the score")
    void testAnalyzeScores_StudentNotFoundException() {
        // arrange
        when(studentDAO.findById(9999L)).thenThrow(StudentNotFoundException.class);

        //act and assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> obtenerDiplomaService.analyzeScores(9999L));
    }

    @Test
    @DisplayName("Student with average equal to nine")
    void testAnalyzeScoreWithAverageEqualToNine() {
        // arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Juan");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // act
        StudentDTO resultStudentDTO = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(
                "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 9,00. Felicitaciones!"
                , resultStudentDTO.getMessage());
    }

    @Test
    @DisplayName("Student with average less than nine")
    void testAnalyzeScoreWithAverageLessThanNine() {
        // arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // act
        StudentDTO resultStudentDTO = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(
                "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 6,00. Puedes mejorar."
                , resultStudentDTO.getMessage());
    }



}