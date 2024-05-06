package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;


    @Test
    void testAnalyzeScores() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        when(service.analyzeScores(1L)).thenReturn(student);

        controller.analyzeScores(1L);

        verify(service).analyzeScores(1L);

        verify(service, atLeastOnce()).analyzeScores(student.getId());
    }
}