package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Promedio de 7, 4 y 10 es igual a 7")
    void averageEqualToSeven() {
        //arr
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 7.0),
                new SubjectDTO("Fisica", 4.0),
                new SubjectDTO("Musica", 10.0)

                );
        StudentDTO mockStudent = new StudentDTO(1L, "Franco", null, null, subjects);

        StudentDTO expectedResult = new StudentDTO(1L, "Franco", "", null, subjects);

        //act
        when(studentDAO.findById(1L)).thenReturn(mockStudent);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(7.0, result.getAverageScore());
    }

}