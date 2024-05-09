package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentServiceTest;
import com.meli.obtenerdiploma.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


/**
 * Ver comentario en {@link StudentServiceTest}.
 */
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;


    /**
     * Este test no chequea el mensaje y promedio calculados por el servicio,
     * ya que eso ya está testeado en el servicio.
     */
    @Test
    void analyzeScoresOk() {

        long studentId = 1;

        StudentDTO outputStudent = StudentUtils.createCommonStudent(studentId);
        outputStudent.setMessage("Good job!");
        outputStudent.setAverageScore(6.5);

        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(outputStudent);

        StudentDTO actualOutput = obtenerDiplomaController.analyzeScores(studentId);

        assertThat(actualOutput).isEqualTo(outputStudent);
    }
}