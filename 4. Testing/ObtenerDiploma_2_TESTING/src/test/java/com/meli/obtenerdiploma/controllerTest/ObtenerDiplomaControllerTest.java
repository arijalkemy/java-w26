package com.meli.obtenerdiploma.controllerTest;


import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Verificar que la informacion del student que me regresa el controlador sea la correcta")
    public void  analyzeScoresTest(){
        StudentDTO expectedStudent = new StudentDTO.Builder()
                .studentName("alexis")
                .setId(1L)
                .build();
        long id  = 1;

        when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(expectedStudent);

        StudentDTO student = obtenerDiplomaController.analyzeScores(id);

        Assertions.assertEquals(expectedStudent.getId(), student.getId());

    }

}
