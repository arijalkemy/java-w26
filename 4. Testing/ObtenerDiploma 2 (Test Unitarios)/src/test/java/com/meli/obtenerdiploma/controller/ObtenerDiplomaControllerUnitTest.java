package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerUnitTest {

    @Mock
    IObtenerDiplomaService servicioDiploma;

    @InjectMocks
    ObtenerDiplomaController controllerDiploma;

    @Test
    @DisplayName("Se obtiene el studentDTO de manera exitosa")
    public void analyzeScoreTest(){
        // ARRANGE
        Long idStudent = 1L;
        StudentDTO estudianEsperado = new StudentDTO();

        // ACT
        when(servicioDiploma.analyzeScores(idStudent)).thenReturn(estudianEsperado);
        StudentDTO estudianteObtenido = controllerDiploma.analyzeScores(idStudent);
        // ASSERT

        Assertions.assertEquals(estudianEsperado, estudianteObtenido);

    }

}
