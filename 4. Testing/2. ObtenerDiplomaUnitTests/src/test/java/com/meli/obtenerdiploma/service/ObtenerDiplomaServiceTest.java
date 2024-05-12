package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    private StudentDTO generateStudentWithScores(List<SubjectDTO> subjects) {
        return StudentDTO.builder()
                .id(1L)
                .studentName("Juan")
                .subjects(subjects)
                .build();
    }

    @Test
    public void analyzeScores_CalculateAverageCorrectly() {
        // Arrange
        StudentDTO studentDTO = generateStudentWithScores(Arrays.asList(
                new SubjectDTO("Matemáticas", 7.0),
                new SubjectDTO("Español", 8.0),
                new SubjectDTO("Ciencias", 9.0)
        ));
        Mockito.when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(8.0, result.getAverageScore());
    }

    @Test
    @DisplayName("Calculate Average Correctly With Empty Subject List")
    public void analyzeScores_CalculateAverageCorrectlyWithEmptySubjectList() {
        // Arrange
        StudentDTO studentDTO = generateStudentWithScores(Collections.emptyList());
        Mockito.when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(0.0, result.getAverageScore());
    }

    @Test
    @DisplayName("Message for High Average")
    public void analyzeScores_MessageForHighAverage() {
        // Arrange
        StudentDTO studentDTO = generateStudentWithScores(Arrays.asList(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Español", 10.0),
                new SubjectDTO("Ciencias", 10.0)
        ));
        Mockito.when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertTrue(result.getMessage().contains("Felicitaciones"));
    }


}
