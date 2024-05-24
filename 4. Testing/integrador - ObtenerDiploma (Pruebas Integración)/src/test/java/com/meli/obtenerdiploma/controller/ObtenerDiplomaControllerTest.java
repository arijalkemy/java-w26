package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO studentDTO;
    @BeforeEach
    public void setup(){
        studentDTO = new StudentDTO(
                1L,
                "",
                null,
                null,
                List.of()
        );
    }

    @Test
    public void analyzeScoresControllerTest(){
        //Arrange
        Long studentId = 1L;
        //Act
        when(iObtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTO);
        StudentDTO actual = obtenerDiplomaController.analyzeScores(studentId);
        //Assert
        assertEquals(studentDTO, actual);
    }
}
