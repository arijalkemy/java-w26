package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(1L, "Camila", List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Física", 4.0)
        ));
    }

    @Test
    @DisplayName("Promedio alumno")
    public void analyzeScores() {
        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO studentDTOActual = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(studentDTO, studentDTOActual);
        assertEquals(studentDTO.getAverageScore(), studentDTOActual.getAverageScore());
        assertEquals(studentDTO.getMessage(), studentDTOActual.getMessage());
    }
}