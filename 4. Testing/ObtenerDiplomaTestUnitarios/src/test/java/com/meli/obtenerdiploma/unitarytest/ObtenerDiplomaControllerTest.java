package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    //Mockear IObtenerDiplomaService
    @Mock
    private IObtenerDiplomaService IbtenerDiplomaService;

    //Inyectar en el controlador
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;
    @BeforeEach
    void setup() {
          MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAnalyzeScores() {
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "El alumno Manuel ha obtenido un promedio de 10. Felicitaciones!", 10.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));

        //Configurando el comportamiento del mock
        when(IbtenerDiplomaService.analyzeScores(123L)).thenReturn(studentDTO);
        //Ejecutando el método a probar
        StudentDTO result = obtenerDiplomaController.analyzeScores(123L);
        //Verificando que el método analyzeScores del mock haya sido llamado
        verify(IbtenerDiplomaService, times(1)).analyzeScores(123L);
        assertEquals("El alumno Manuel ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());

    }


}
