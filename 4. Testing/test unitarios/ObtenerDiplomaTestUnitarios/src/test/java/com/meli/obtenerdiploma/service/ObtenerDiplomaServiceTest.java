package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.StudentDTOGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDao;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;
    private StudentDTO studentDTO;
    private List<SubjectDTO> studentSubjects;
    private StudentDTO studentDTO2;

    @BeforeEach
    public void setup() {
        studentSubjects = StudentDTOGenerator.generateSubjectsDTOWithAverage(9);

        studentDTO = StudentDTOGenerator.generateStudentDTO(1L, "Facundo Lopez", studentSubjects);

        studentDTO2 = StudentDTOGenerator.generateStudentDTO(2L, "Hernan Perez",
                StudentDTOGenerator.generateSubjectsDTOWithAverage(9.1)
        );
    }

    @Test
    @DisplayName("check output data from analyzeScores with invalid input")
    public void analyzeScoresOutputDataInvalidInput() {
        when(studentDao.findById(0L)).thenThrow(new StudentNotFoundException(0L));

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> {
                    studentDao.findById(0L);
                }
        );
    }

    @Test
    @DisplayName("check output data from analyzeScores with valid input")
    public void analyzeScoresOutputDataValidInput() {

        when(studentDao.findById(1L)).thenReturn(
                studentDTO
        );

        var result = studentDao.findById(1L);

        StudentDTO expectedResult = studentDTO;

        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    @DisplayName("get average of student from analyzeScores")
    public void analyzeScoresAverage() {
        //Arrange
        double totalScore = studentSubjects.stream().mapToDouble(s -> s.getScore()).sum();
        double waitedAverage = totalScore / studentSubjects.size();

        //Act
        when(studentDao.findById(1L)).thenReturn(
                studentDTO
        );
        StudentDTO obtainedStudent = obtenerDiplomaService.analyzeScores(1L);
        var obtainedAverage = obtainedStudent.getAverageScore();

        // Assert
        Assertions.assertEquals(obtainedAverage, waitedAverage);

    }

    @Test
    @DisplayName("Get message from analize Scores lower or equal 9")
    public void analyzeScoresMessageLowerOr9() {
        when(studentDao.findById(1L)).thenReturn(
                studentDTO
        );

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        String expectedMesage = "El alumno " + result.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(result.getAverageScore())
                + ". Puedes mejorar.";

        String obtainedMessage = result.getMessage();

        Assertions.assertEquals(expectedMesage, obtainedMessage);
    }

    @Test
    @DisplayName("Get message from analize Scores higher than 9")
    public void analyzeScoresMessageHigherThan9() {
        when(studentDao.findById(2L)).thenReturn(
                studentDTO2
        );

        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

        String expectedMesage = "El alumno " + result.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(result.getAverageScore())
                + ". Felicitaciones!";

        String obtainedMessage = result.getMessage();

        Assertions.assertEquals(expectedMesage, obtainedMessage);
    }


}
