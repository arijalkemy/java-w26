package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    private StudentDTO student;

    @BeforeEach
    public void setUp() {
        TestGenerator testGenerator = new TestGenerator();
        student = testGenerator.getStudentDTO();
    }

    @Test
    public void analyzeScores() {
        // arrange
        when(service.analyzeScores(student.getId())).thenReturn(student);
        // act
       StudentDTO resultado= controller.analyzeScores(student.getId());

        // assert
        verify(service).analyzeScores(student.getId());
        assertEquals(student, resultado);
    }
}
