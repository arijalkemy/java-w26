package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    @DisplayName("Test para obtener el promedio de un alumno")
    void analyzeScores() {
        // Arrange
        StudentDTO mockStudent = new StudentDTO();
        mockStudent.setStudentName("Test student");
        mockStudent.setId(2L);
        mockStudent.setSubjects(Arrays.asList(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0)));

        when(studentDAO.findById(2L)).thenReturn(mockStudent);

        // Act
        StudentDTO result = service.analyzeScores(2L);

        // Assert
        assertEquals("Test student", result.getStudentName());
        assertEquals(8.5, result.getAverageScore());
        assertEquals("El alumno Test student ha obtenido un promedio de 8,5. Puedes mejorar.", result.getMessage());
    }
}