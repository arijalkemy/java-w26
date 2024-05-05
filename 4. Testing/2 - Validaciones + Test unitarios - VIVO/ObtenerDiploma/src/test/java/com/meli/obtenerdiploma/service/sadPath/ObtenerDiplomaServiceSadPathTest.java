package com.meli.obtenerdiploma.service.sadPath;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceSadPathTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("it should throw StudentNotFoundException when student not found")
    public void analyzeScoresStudentNotFoundTest() {
        // arrange
        Long nonExistingStudentId = 9999L;
        when(studentDAO.findById(nonExistingStudentId)).thenThrow(StudentNotFoundException.class);

        // act & assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(nonExistingStudentId));
    }

    @Test
    @DisplayName("it should return a invalid averageScore for empty subjects list")
    public void analyzeScoresEmptySubjectsListTest() {
        // arrange
        String message = "El alumno Juan ha obtenido un promedio de 0.0. Puedes mejorar.";
        StudentDTO studentWithEmptySubjectsList = new StudentDTO();
        studentWithEmptySubjectsList.setId(1L);
        studentWithEmptySubjectsList.setSubjects(Collections.emptyList());

        // act
        when(studentDAO.findById(1L)).thenReturn(studentWithEmptySubjectsList);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // assert
        assertNotEquals(10.0, result.getAverageScore());
    }

    @Test
    @DisplayName("it should return a averageScore with negative scores")
    public void analyzeScoresInvalidScoresTest() {
        // arrange
        Long studentIdWithNegativeSubjectScores = 1L;
        StudentDTO studentWithNegativeSubjectScores = new StudentDTO();
        studentWithNegativeSubjectScores.setId(studentIdWithNegativeSubjectScores);
        studentWithNegativeSubjectScores.setStudentName("Juan");
        List<SubjectDTO> subjectsWithInvalidScores = Arrays.asList(
                new SubjectDTO("Math", -5.0),
                new SubjectDTO("Physics", 11.0)
        );
        studentWithNegativeSubjectScores.setSubjects(subjectsWithInvalidScores);

        // act
        double averageScoreWithNegativeScores = studentWithNegativeSubjectScores.getSubjects().stream().mapToDouble(x -> x.getScore()).average().orElse(0.0);
        when(studentDAO.findById(studentIdWithNegativeSubjectScores)).thenReturn(studentWithNegativeSubjectScores);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentIdWithNegativeSubjectScores);

        // assert
        assertEquals(result.getAverageScore(), averageScoreWithNegativeScores);
    }

    @Test
    @DisplayName("it should return a invalid message")
    public void invalidMessageTest(){
        // arrange
        Long studentIdWithNegativeSubjectScores = 1L;
        StudentDTO studentWithNegativeSubjectScores = new StudentDTO();
        studentWithNegativeSubjectScores.setId(studentIdWithNegativeSubjectScores);
        studentWithNegativeSubjectScores.setStudentName("Juan");
        List<SubjectDTO> subjectsWithInvalidScores = Arrays.asList(
                new SubjectDTO("Math", -5.0),
                new SubjectDTO("Physics", 11.0)
        );
        studentWithNegativeSubjectScores.setSubjects(subjectsWithInvalidScores);

        // act
        double averageScoreWithNegativeScores = studentWithNegativeSubjectScores.getSubjects().stream().mapToDouble(x -> x.getScore()).average().orElse(0.0);
        String message = String.format("El alumno %s ha obtenido un promedio de: %f. Felicitaciones!",
                studentWithNegativeSubjectScores.getStudentName(),
                averageScoreWithNegativeScores
        );
        when(studentDAO.findById(studentIdWithNegativeSubjectScores)).thenReturn(studentWithNegativeSubjectScores);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentIdWithNegativeSubjectScores);

        // assert
        assertNotEquals(result.getMessage(), message);
    }

}
