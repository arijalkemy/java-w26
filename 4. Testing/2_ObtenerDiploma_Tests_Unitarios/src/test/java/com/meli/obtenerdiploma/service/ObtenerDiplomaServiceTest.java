package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.StudentUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Ver comentario en {@link StudentServiceTest}.
 */
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Cálculo del promedio de un alumno sobresaliente")
    public void analyzeScoresCongratulationsTest() {

        long studentId = 1;

        StudentDTO studentDTO = StudentUtils.createOutstandingStudent(studentId);

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertThat(result.getAverageScore()).isEqualTo(9.5);
        assertThat(result.getMessage()).contains("Felicitaciones!");
    }

    @Test
    @DisplayName("Cálculo del promedio de un alumno con notas 'normales'")
    public void analyzeScoresCanDoBetterTest() {

        long studentId = 1;

        StudentDTO studentDTO = StudentUtils.createCommonStudent(studentId);

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertThat(result.getAverageScore()).isEqualTo(5.5);
        assertThat(result.getMessage()).contains("Puedes mejorar");
    }

}