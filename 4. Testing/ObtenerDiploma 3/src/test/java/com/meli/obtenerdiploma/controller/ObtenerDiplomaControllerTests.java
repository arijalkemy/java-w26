package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
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

    StudentDTO studentDTO;

    @BeforeEach
    void setupTest(){
        studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
    }

    @Test
    public void testAnalyzeScores(){
        controller.analyzeScores(studentDTO.getId());

        verify(service, atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}
