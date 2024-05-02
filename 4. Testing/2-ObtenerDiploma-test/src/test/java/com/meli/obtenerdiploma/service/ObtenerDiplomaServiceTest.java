package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    StudentDTO studentFromRepository = new StudentDTO();

    @BeforeEach
    void setup(){
        studentFromRepository.setId(1L);
        studentFromRepository.setStudentName("Juan");

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));
        studentFromRepository.setSubjects(subjects);
    }

    @Test
    void analyzeScoresWithId1(){
        Long id = 1L;

        when(studentDAO.findById(id)).thenReturn(studentFromRepository);

        StudentDTO expectedResult = new StudentDTO();
        expectedResult.setId(1L);
        expectedResult.setStudentName("Juan");

        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects2.add(new SubjectDTO("Matemática", 9.0));
        subjects2.add(new SubjectDTO("Física", 7.0));
        subjects2.add(new SubjectDTO("Química", 6.0));
        expectedResult.setSubjects(subjects2);
        expectedResult.setAverageScore(7.333333333333333);
        expectedResult.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");

        var student = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertEquals(expectedResult, student);
    }
}
