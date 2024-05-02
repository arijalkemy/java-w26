package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO studentJuanPerez;

    @BeforeEach
    public void setup() {
        studentJuanPerez = new StudentDTO(
                1L,
                "Juan Perez",
                "",
                9.0,
                List.of(new SubjectDTO("Matematica", 9.0))
        );
    }

    @Test
    @DisplayName("Se calcula el promedio de Juan Perez correctamente")
    public void analyzeScoresSuccessfully() {
        when(obtenerDiplomaService.analyzeScores(studentJuanPerez.getId())).thenReturn(studentJuanPerez);
        StudentDTO resultStudentDTO = obtenerDiplomaController.analyzeScores(1L);
        assertEquals(resultStudentDTO.getAverageScore(), studentJuanPerez.getAverageScore());
    }

    @Test
    @DisplayName("Se intenta calcular el promedio de un usuario inexistente y lanza excepcion")
    public void analyzeScoresThrowsException(){
        when(obtenerDiplomaService.analyzeScores(2L)).thenThrow(StudentNotFoundException.class);
        assertThrows(
                StudentNotFoundException.class,
                () -> obtenerDiplomaController.analyzeScores(2L)
        );
    }

}
