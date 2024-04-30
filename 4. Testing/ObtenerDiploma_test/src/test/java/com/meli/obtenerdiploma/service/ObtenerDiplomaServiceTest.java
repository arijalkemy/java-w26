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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    public IStudentDAO studentDAO;

    @InjectMocks
    public ObtenerDiplomaService obtenerDiplomaService;

    public Set<StudentDTO> studentDTOS;

    public Set<StudentDTO> getMockStudents() {
        return new HashSet<>(
                List.of(
                        new StudentDTO(1L, "Juan Manuel", null, null, new ArrayList<>(
                                List.of(
                                        new SubjectDTO("Matemática", 9.0),
                                        new SubjectDTO("Física", 7.0),
                                        new SubjectDTO("Química", 6.0)
                                )
                        )),
                        new StudentDTO(2L, "Pedro", null, null, new ArrayList<>(
                                List.of(
                                        new SubjectDTO("Matemática", 10.0),
                                        new SubjectDTO("Física", 8.0),
                                        new SubjectDTO("Química", 4.0)
                                )
                        )),
                        new StudentDTO(3L, "Mariano", null, null, new ArrayList<>(
                                List.of(
                                        new SubjectDTO("Matemática", 9.0),
                                        new SubjectDTO("Física", 7.0),
                                        new SubjectDTO("Química", 6.0)
                                )
                        ))
                )
        );
    }

    @BeforeEach
    public void setup() {
        this.studentDTOS = getMockStudents();
    }

    // analyzeScores Tests
    @Test
    @DisplayName("Get valid StudentDto when consulting analyzeScores")
    public void analyzeScoresOk() {
        // Given - Arrange
        StudentDTO student = studentDTOS.iterator().next();
        Mockito.when(studentDAO.findById(1L)).thenReturn(student);

        // When - Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Then - Assert
        Assertions.assertNotNull(result.getAverageScore());
        Assertions.assertNotNull(result.getMessage());
        Assertions.assertEquals(student, result);
    }

    @Test
    @DisplayName("Analyze scores with null value")
    public void analyzeScoresNull() {
        // Given - Arrange
        Mockito.when(studentDAO.findById(null)).thenThrow(StudentNotFoundException.class);

        // When - Act
        // Then - Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    @DisplayName("Get exception when consulting analyzeScores with non existent ID")
    public void analyzeScoresNonExistentId() {
        // Given - Arrange
        Long nonExistentId = 33L;
        Mockito.when(studentDAO.findById(33L)).thenThrow(StudentNotFoundException.class);

        // When - Act
        // Then - Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(nonExistentId));
    }
}
