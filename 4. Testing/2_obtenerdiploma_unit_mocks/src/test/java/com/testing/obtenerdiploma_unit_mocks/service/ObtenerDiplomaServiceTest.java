package com.testing.obtenerdiploma_unit_mocks.service;

import com.testing.obtenerdiploma_unit_mocks.exception.StudentNotFoundException;
import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;
import com.testing.obtenerdiploma_unit_mocks.model.SubjectDTO;
import com.testing.obtenerdiploma_unit_mocks.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresWithExistingStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
            1L,
            "Juan",
            "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.33,
            List.of(
            new SubjectDTO("Matematicas",9.0),
            new SubjectDTO("Fisica",6.0),
            new SubjectDTO("ASDASDASD",7.0)
            )
        );

        Mockito.when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // act
        StudentDTO result = this.obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // assert
        Assertions.assertEquals(studentDTO, result);
    }

    @Test
    void analyzeScoresWithUnknownStudent() {
        // Arrange
        Long studentId = 100L;

        Mockito.when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> this.obtenerDiplomaService.analyzeScores(studentId));
    }
}