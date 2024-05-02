package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
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
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @BeforeEach
    void setUp(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setId(0L);

        when(obtenerDiplomaService.analyzeScores(0L)).thenReturn(studentDTO);
    }

    @Test
    @DisplayName("Se ejecuta el endpoint analyzeScores correctamente")
    public void testAnalyzeScores(){
        obtenerDiplomaController.analyzeScores(0L);
        Assertions.assertEquals("Juan", obtenerDiplomaController.analyzeScores(0L).getStudentName());
    }
}
