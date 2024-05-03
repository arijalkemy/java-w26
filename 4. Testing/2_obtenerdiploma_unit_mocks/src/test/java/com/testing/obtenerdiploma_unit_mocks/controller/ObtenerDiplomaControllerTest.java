package com.testing.obtenerdiploma_unit_mocks.controller;

import com.testing.obtenerdiploma_unit_mocks.exception.StudentNotFoundException;
import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;
import com.testing.obtenerdiploma_unit_mocks.model.SubjectDTO;
import com.testing.obtenerdiploma_unit_mocks.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresOfKnownStudent() {
        // Arrange
        Long id = 1L;

        StudentDTO studentDTO = new StudentDTO(1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        when(this.obtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTO);

        // Act
        StudentDTO result = this.obtenerDiplomaController.analyzeScores(id);

        // Assert
        Assertions.assertEquals(id, result.getId());
    }

    @Test
    void analyzeScoresOfUnknownStudent() throws Exception {
        // Arrange
        Long id = 100L;

        // Act & Arrange
        Assertions.assertThrows(StudentNotFoundException.class, () -> this.obtenerDiplomaController.analyzeScores(id));
    }
}