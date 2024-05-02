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
    @DisplayName("Se obtiene el promedio exitosamente")
    void analyzeScoresSuccessfullyTest() {
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
        subjectDTOList.add(
                new SubjectDTO(
                        "Química",
                        6.0
                )
        );

        StudentDTO expectedResult = new StudentDTO(
            1L,
            "Juan",
            null,
            7.33,
            subjectDTOList
        );

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(result, expectedResult);
    }
}
