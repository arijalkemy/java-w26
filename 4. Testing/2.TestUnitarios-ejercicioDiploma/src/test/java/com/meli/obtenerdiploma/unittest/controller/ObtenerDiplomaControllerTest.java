package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Se llama al controller con un estudiante existente")
    public void ScoreforExistStudentTest() {
        StudentDTO studentMock = new StudentDTO();
        studentMock.setId(9999L);
        studentMock.setStudentName("Juan");
        studentMock.setMessage("mensaje");
        studentMock.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentMock.setSubjects(List.of(subjectDTO));

        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentMock);
        StudentDTO studentDTO = obtenerDiplomaController.analyzeScores(1L);
        Assertions.assertEquals(studentDTO, studentMock);
    }
}
