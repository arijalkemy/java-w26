package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {



    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    StudentDTO studentDTO;

    @BeforeEach
    public void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Pedro");
        studentDTO.setId(1L);
    }

    @Test
    @DisplayName("analizar score por id estudiante")
    public void analizarScorePorIdTest() throws Exception {

        when(service.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO respuestEstudiante =  controller.analyzeScores(studentDTO.getId());

        Assertions.assertEquals(studentDTO, respuestEstudiante);
    }
}
