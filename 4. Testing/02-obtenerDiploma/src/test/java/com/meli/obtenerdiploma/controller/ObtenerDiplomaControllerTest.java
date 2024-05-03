package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

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
    void analyzeScores() {
        obtenerDiplomaController.analyzeScores(studentDTO.getId());
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}