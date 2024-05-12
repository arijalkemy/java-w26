package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresSadPath() {
        when(studentDAO.findById(null)).thenThrow(new StudentNotFoundException(null));
        assertThrows(StudentNotFoundException.class, () -> this.obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    public void analyzeScoresHonorem() {
        // Arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 10.0));
        subjects.add(new SubjectDTO("Science", 10.0));
        StudentDTO student = new StudentDTO(studentId, "Jane Doe", null, null, subjects);
        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(10, result.getAverageScore());
        assertEquals("El alumno Jane Doe ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }

    @Test
    public void analyzeScores() {
        // Arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 5.0));
        subjects.add(new SubjectDTO("Science", 7.0));
        StudentDTO student = new StudentDTO(studentId, "Jane Doe", null, null, subjects);
        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(6, result.getAverageScore());
        assertEquals("El alumno Jane Doe ha obtenido un promedio de 6. Puedes mejorar.", result.getMessage());
    }
}
