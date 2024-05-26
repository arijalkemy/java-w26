package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    private StudentDTO student;


    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        student = StudentDTO.builder()
                .id(1L)
                .studentName("Joaquin")
                .subjects(Arrays.asList(
                        SubjectDTO.builder().name("Math").score(90.0).build(),
                        SubjectDTO.builder().name("Science").score(90.0).build()
                ))
                .build();
    }

    @Test
    public void analyzeScoresTest() {
        // Arrange
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(student.getId());

        // Assert
        assertEquals(student.getStudentName(), result.getStudentName());
        assertEquals(90.0, result.getAverageScore());
        assertEquals("El alumno Joaquin ha obtenido un promedio de 90. Felicitaciones!", result.getMessage());
    }

    @Test
    public void analyzeScoresTest_NullStudent() {
        // Arrange
        when(studentDAO.findById(1L)).thenReturn(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

    @Test
    public void analyzeScoresTest_InvalidScore() {
        // Arrange
        StudentDTO student = StudentDTO.builder()
                .id(1L)
                .studentName("Joaquin")
                .subjects(Arrays.asList(
                        SubjectDTO.builder().name("Math").score(-10.0).build(),
                        SubjectDTO.builder().name("Science").score(90.0).build()
                ))
                .build();
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }


    @Test
    public void getGreetingMessageTest() {
        // Arrange
        String studentName = "Joaquin";
        Double average = 9.5;
        String expectedResult = "El alumno Joaquin ha obtenido un promedio de 9.5. Felicitaciones!";

        // Act
        String result = obtenerDiplomaService.getGreetingMessage(studentName, average);

        // Assert
        assertEquals(expectedResult, result);
    }
}
