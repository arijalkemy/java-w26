package com.meli.obtenerdiploma.unit.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentBuilder;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    //Dependencies
    @Mock
    private IObtenerDiplomaService obtenerDiplomaServiceMock;    

    @InjectMocks
    private ObtenerDiplomaController systemUnderTest;

    @Test
    @DisplayName("Test AnalyzeScore")
    public void analyzeScores() {

        //Arrange
        Long idStudent = 1L;
        StudentDTO expected = StudentBuilder.getStudentTest();

        //Act
        when(obtenerDiplomaServiceMock.analyzeScores(idStudent)).thenReturn(expected);
        StudentDTO response = systemUnderTest.analyzeScores(idStudent);        

        //Assertions
        verify(obtenerDiplomaServiceMock, times(1)).analyzeScores(idStudent);
        Assertions.assertEquals(expected, response);
    }
}
