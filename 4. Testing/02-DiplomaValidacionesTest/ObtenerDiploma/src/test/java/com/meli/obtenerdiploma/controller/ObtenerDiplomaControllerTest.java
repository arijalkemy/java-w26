package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static com.meli.obtenerdiploma.util.UtilStudentGenerator.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analize Scores (Controller) Test")
    public void analizeScoresTest(){
        //arrange
        StudentDTO studentExpected = studentWithBelow9Average("Arthur Morgan", 1L);

        //act
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentExpected);
        StudentDTO studentObtained = obtenerDiplomaController.analyzeScores(1L);

        //assert
        Assertions.assertEquals(studentExpected, studentObtained);
    }

}
