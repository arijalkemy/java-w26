package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Se obtiene promedio > 9 exitosamente")
    void analyzeScoresMoreThan9Test() {
        // Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
        subjectDTOList.add(
                new SubjectDTO(
                       "Matemática",
                        9.0
                )
        );
        subjectDTOList.add(
                new SubjectDTO(
                        "Física",
                        10.0
                )
        );

        StudentDTO studentDTO = new StudentDTO(
            1L,
            "Juan",
            null,
            7.33,
            subjectDTOList
        );

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(result.getAverageScore(), 9.5);
        Assertions.assertEquals(
                result.getMessage(),
                "El alumno Juan ha obtenido un promedio de 9.5. Felicitaciones!"
        );    }

    @Test
    @DisplayName("Se obtiene promedio < 9 exitosamente")
    void analyzeScoresLessThan9Test() {
        // Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
        subjectDTOList.add(
                new SubjectDTO(
                        "Matemática",
                        9.0
                )
        );
        subjectDTOList.add(
                new SubjectDTO(
                        "Física",
                        7.0
                )
        );

        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Juan",
                null,
                7.33,
                subjectDTOList
        );

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(result.getAverageScore(), 8);
        Assertions.assertEquals(
                result.getMessage(),
                "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar."
        );
    }

    @Test
    @DisplayName("Calcular promedio: Excepción al recibir Id null")
    void analyzeScoresNullIdTest() {
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
           obtenerDiplomaService.analyzeScores(null);
        });
    }

    @Test
    @DisplayName("Calcular promedio: Excepción al recibir Id de estudiante inexistente")
    void analyzeScoresNegativeIdTest() {
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            obtenerDiplomaService.analyzeScores(-1L);
        });
    }
}
