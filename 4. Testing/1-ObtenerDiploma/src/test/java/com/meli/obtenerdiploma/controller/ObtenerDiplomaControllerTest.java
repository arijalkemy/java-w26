package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;


    @Test
    public void analyzeScores() {
        // Arrange
        Long studentId = 123L;
        StudentDTO expectedStudentDTO = new StudentDTO();

        // mockear el comportamiento del servicio
        when(service.analyzeScores(studentId)).thenReturn(expectedStudentDTO);

        // Act
        StudentDTO response = controller.analyzeScores(studentId);

        // Assert
        assertEquals(expectedStudentDTO, response);
    }

}
