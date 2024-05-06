package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
//ejercicio 2
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Informacion de un estudiante con promedio y mensaje")
    void analyzeScores() {
        // Arrange (el parametro requerido y el tipo de devolucion)
        StudentDTO expected = new StudentDTO(1L, "John Doe","message",8D,
                List.of(
                new SubjectDTO("Math", 10D),
                new SubjectDTO("Science", 9D),
                new SubjectDTO("History", 8D)));
        //cuando llamen a este metodo entonces devolver el objeto esperado
        when(studentDAO.findById(1L)).thenReturn(expected);

        //Act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(expected, actual);
        assertEquals(expected.getAverageScore(), actual.getAverageScore());
        assertEquals(expected.getMessage(), actual.getMessage());
    }



}