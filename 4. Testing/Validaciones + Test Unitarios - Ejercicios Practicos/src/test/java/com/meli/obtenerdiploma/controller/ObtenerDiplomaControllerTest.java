package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    @DisplayName("El método analyzeScores debe retornar un objeto StudentDTO")
    public void analyzeScoresTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(studentId);
        newStudent.setStudentName("Juan");
        newStudent.setSubjects(
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Lengua", 8.0),
                        new SubjectDTO("Historia", 9.0)
                )
        );
        newStudent.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        newStudent.setAverageScore(7.3);

        // Act
        when(service.analyzeScores(studentId)).thenReturn(newStudent);

        // Assert
        StudentDTO response = controller.analyzeScores(studentId);

        verify(service, atLeastOnce()).analyzeScores(studentId);
        Assertions.assertEquals(newStudent, response);
    }

    @Test
    @DisplayName("El método analyzeScores debe retornar null si el usuario no existe")
    public void analyzeScoresTestNull() {
        // Arrange
        Long studentId = 1L;

        // Act
        when(service.analyzeScores(studentId)).thenReturn(null);

        // Assert
        StudentDTO response = controller.analyzeScores(studentId);

        verify(service, atLeastOnce()).analyzeScores(studentId);
        Assertions.assertNull(response);
    }
}
