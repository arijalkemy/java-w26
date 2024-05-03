package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController = new ObtenerDiplomaController();


    @Test
    void analyzeScoresWithGreatAverageTest() {

        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Math", 10D),
                new SubjectDTO("Science", 9D)
        );

        StudentDTO studentInputDTO = new StudentDTO();
        studentInputDTO.setId(1L);
        studentInputDTO.setStudentName("John Doe");
        studentInputDTO.setSubjects(subjectDTOList);

        StudentDTO studentExpectedDTO = new StudentDTO();
        studentExpectedDTO.setId(1L);
        studentExpectedDTO.setStudentName("John Doe");
        studentExpectedDTO.setAverageScore(9.5);
        studentExpectedDTO.setSubjects(subjectDTOList);
        studentExpectedDTO.setMessage("El alumno John Doe ha obtenido un promedio de 9.5. Felicitaciones!");


        when(service.analyzeScores(1L)).thenReturn(studentExpectedDTO);


        StudentDTO studentResponseDTO = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertEquals(studentExpectedDTO, studentResponseDTO);
    }

    @Test
    void analyzeScoresWithLowAverageTest() {

        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Math", 5D),
                new SubjectDTO("Science", 4D)
        );

        StudentDTO studentInputDTO = new StudentDTO();
        studentInputDTO.setId(1L);
        studentInputDTO.setStudentName("John Doe");
        studentInputDTO.setSubjects(subjectDTOList);

        StudentDTO studentExpectedDTO = new StudentDTO();
        studentExpectedDTO.setId(1L);
        studentExpectedDTO.setStudentName("John Doe");
        studentExpectedDTO.setAverageScore(4.5);
        studentExpectedDTO.setSubjects(subjectDTOList);
        studentExpectedDTO.setMessage("El alumno John Doe ha obtenido un promedio de 4.5. Puedes mejorar.");

        when(service.analyzeScores(1L)).thenReturn(studentExpectedDTO);

        StudentDTO studentResponseDTO = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertEquals(studentExpectedDTO, studentResponseDTO);
    }
}