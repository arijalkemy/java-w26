package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.GenerateStudentsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    StudentDTO studentDTO;

    @BeforeEach
    void setupTest(){
        studentDTO = GenerateStudentsTest.generateStudent();
    }

    @Test
    public void testAnalyzeScores(){
        controller.analyzeScores(studentDTO.getId());

        verify(service, atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}
