package com.meli.obtenerdiploma.units.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("analza el score de un estudiante por su id")
    public void analyzeScoresTest() {
        //Arrange
        StudentDTO expected = TestUtils.createStudentDTO();

        //Act
        when(obtenerDiplomaService.analyzeScores(expected.getId())).thenReturn(expected);
        StudentDTO output = controller.analyzeScores(expected.getId());

        //Assert
        Assertions.assertEquals(expected, output);
    }
}
