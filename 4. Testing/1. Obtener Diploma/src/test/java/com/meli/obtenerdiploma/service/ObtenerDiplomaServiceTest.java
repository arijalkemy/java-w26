package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresAverageLowerThan9() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 8.0)));

        StudentDTO studentExceptedDTO = new StudentDTO();

        studentExceptedDTO.setStudentName("Juan");
        studentExceptedDTO.setSubjects(List.of(new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 8.0)));
        studentExceptedDTO.setAverageScore(9.0);
        studentExceptedDTO.setMessage("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.");

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        //act

        StudentDTO studentResultDTO = obtenerDiplomaService.analyzeScores(1L);

        //assert

        Assertions.assertEquals(studentExceptedDTO, studentResultDTO);
    }

    @Test
    void analyzeScoresMessageWithAverageGreaterThan9() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0)));

        StudentDTO studentExceptedDTO = new StudentDTO();

        studentExceptedDTO.setStudentName("Juan");
        studentExceptedDTO.setSubjects(List.of(new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0)));
        studentExceptedDTO.setAverageScore(10.0);
        studentExceptedDTO.setMessage("El alumno Juan ha obtenido un promedio de 10. Felicitaciones!");

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        //act

        StudentDTO studentResultDTO = obtenerDiplomaService.analyzeScores(1L);

        //assert

        Assertions.assertEquals(studentExceptedDTO, studentResultDTO);
    }

    @Test
    void analyzeScoresWithAStudentWithEmptySubjects() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of());

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO studentExpectedDTO = new StudentDTO();
        studentExpectedDTO.setStudentName("Juan");
        studentExpectedDTO.setSubjects(List.of());
        studentExpectedDTO.setAverageScore(0.0);
        studentExpectedDTO.setMessage("El alumno Juan ha obtenido un promedio de 0. Puedes mejorar.");


        // act
        StudentDTO studentResultDTO = obtenerDiplomaService.analyzeScores(1L);

        // assert
        Assertions.assertEquals(studentExpectedDTO, studentResultDTO);
    }

    @Test
    void analyzeScoresWithAStudentWithNullSubjects() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(null);

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO studentExpectedDTO = new StudentDTO();
        studentExpectedDTO.setStudentName("Juan");
        studentExpectedDTO.setSubjects(null);
        studentExpectedDTO.setAverageScore(0.0);
        studentExpectedDTO.setMessage("El alumno Juan ha obtenido un promedio de 0. Puedes mejorar.");

        // act
        StudentDTO studentResultDTO = obtenerDiplomaService.analyzeScores(1L);

        // assert
        Assertions.assertEquals(studentExpectedDTO, studentResultDTO);
    }
}