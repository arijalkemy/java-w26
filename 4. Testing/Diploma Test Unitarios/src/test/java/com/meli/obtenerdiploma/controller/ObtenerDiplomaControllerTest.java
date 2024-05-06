package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentUseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @DisplayName("Analizar el puntaje del estudiante")
    @Test
    public void analizarDiplomaEstudiante() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageLessTen();

        //Act
        obtenerDiplomaController.analyzeScores(studentDTO.getId());

        //Assert
        Mockito.verify(obtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(studentDTO.getId());
    }

    @DisplayName("Analizar el puntaje del estudiante que no existe")
    @Test
    public void analizarDiplomaEstudianteNoExciste() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentTest();

        //Act
        obtenerDiplomaController.analyzeScores(studentDTO.getId());

        //Assert
        Mockito.verify(obtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}
