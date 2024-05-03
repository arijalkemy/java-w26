package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO student;


    @BeforeEach
    void loadStudent() {
        student = new StudentDTO(
                1L, "Cristopher", null, null,
                List.of(new SubjectDTO("Matemáticas", 4.5), new SubjectDTO("Sociales", 6.5))
        );
    }

    @DisplayName("Test cuando el estudiante no existe - analyzeScores")
    @Test
    void studentNullAnalyzeScoresTest() {
        // Arrange
        when(studentDAO.findById(1L)).thenThrow(StudentNotFoundException.class);
        // Act - Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

    @DisplayName("Test promedio 5.5 - analyzeScores")
    @Test
    void successfulAverageAnalyzeScoresTest() {
        // Arrange
        when(studentDAO.findById(1L)).thenReturn(student);
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        // Assert
        assertEquals(5.5, result.getAverageScore());
    }

    @DisplayName("Test Datos de Salida idénticos a datos de Entrada - analyzeScores")
    @Test
    void identicDataAnalyzeScoresTest() {
        // Arrange
        when(studentDAO.findById(1L)).thenReturn(student);
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        // Assert
        assertAll(
                () -> assertEquals(student.getStudentName(), result.getStudentName()),
                () -> assertEquals(student.getSubjects(), result.getSubjects()),
                () -> assertEquals(student.getId(), result.getId())
        );
    }

    @DisplayName("Test diploma sin honores - analyzeScores")
    @Test
    void successfulWhitoutHonorAnalyzeScoresTest() {
        // Arrange
        when(studentDAO.findById(1L)).thenReturn(student);
        String diplomaEsperado = "El alumno " + student.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(5.5) + ". Puedes mejorar.";
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        // Assert
        assertEquals(diplomaEsperado, result.getMessage());
    }

    @DisplayName("Test diploma con honores - analyzeScores")
    @Test
    void successfulHonorAnalyzeScoresTest() {
        // Arrange
        student.setSubjects(
                List.of(new SubjectDTO("Matemáticas", 9.5), new SubjectDTO("Sociales", 9.1))
        );
        when(studentDAO.findById(1L)).thenReturn(student);
        String diplomaEsperado = "El alumno " + student.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(9.3) + ". Felicitaciones!";
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        // Assert
        assertEquals(diplomaEsperado, result.getMessage());
    }

}