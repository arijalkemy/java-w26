package com.meli.obtenerdiploma.serviceTest;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Calcular que el average y el menssage se esten generando correctamente ")
    public void calculateAverageTest(){

        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Ingles", 10.0),
                new SubjectDTO("Geografia", 10.0)
        );
        StudentDTO student = new StudentDTO.Builder()
                .studentName("Alexis")
                .setId(1001L)
                .subjects(subjects)
                .build();

        when(studentDAO.findById(1001L)).thenReturn(student);


        StudentDTO analyzedStudent = obtenerDiplomaService.analyzeScores(1001L);

        Assertions.assertEquals(analyzedStudent.getAverageScore(), 10.0);
    }
}
