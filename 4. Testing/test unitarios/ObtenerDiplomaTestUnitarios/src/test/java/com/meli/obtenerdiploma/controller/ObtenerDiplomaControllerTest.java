package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentDTOGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO studentDTO;
    private Long id;
    private Long notExisitingId;

    @BeforeEach
    public void setup(){
        id = 1L;
        notExisitingId = 2L;
        studentDTO = StudentDTOGenerator.generateStudentDTO(
                id,
                "Juan perez",
                StudentDTOGenerator.generateSubjectsDTOWithAverage(9)
        );
    }

    @Test
    @DisplayName("test analizeScores endpoint ok")
    public void analyzeScoresTest(){
        when(obtenerDiplomaController.analyzeScores(id)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaController.analyzeScores(id);
        verify(service,atLeastOnce()).analyzeScores(id);
        Assertions.assertEquals(result, studentDTO);
    }

    @Test
    @DisplayName("test analizeScores endpoint bath Request")
    public void analyzeScoresTestBadPath(){
        when(service.analyzeScores(notExisitingId))
                .thenThrow(new StudentNotFoundException(notExisitingId));
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> obtenerDiplomaController.analyzeScores(notExisitingId));
        verify(service,atLeastOnce()).analyzeScores(notExisitingId);
    }
}
