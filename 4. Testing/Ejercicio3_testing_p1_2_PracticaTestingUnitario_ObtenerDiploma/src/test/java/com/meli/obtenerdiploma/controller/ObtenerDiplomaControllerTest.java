package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService service;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Test - Con base de un ID valido se obtiene un StudentDTO con score")
    public void analyzeScores(){
        //Arrange: Se define los requisitos que debe de cumplir de entrada y de salida
        Long id = 2L;

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO_esperado = new StudentDTO();
        studentDTO_esperado.setId(2L);
        studentDTO_esperado.setStudentName("Pedro");
        studentDTO_esperado.setSubjects(subjectDTOList);
        studentDTO_esperado.setMessage("El alumno Criss ha obtenido un promedio de ...");
        //Act: Llamado del codigo a probar
        Mockito.when(service.analyzeScores(id)).thenReturn(studentDTO_esperado);
        StudentDTO studentDTO_obtenido = obtenerDiplomaController.analyzeScores(id);

        //Assert: Comprobación de los resultados
        Assertions.assertEquals(studentDTO_esperado, studentDTO_obtenido);
    }

    @Test
    @DisplayName("Test - sin un ID como parametro se obtiene una excepcion")
    public void analyzeScores_notNull(){
        //Arrange: Se define los requisitos que debe de cumplir de entrada y de salida
        Long id = null;
        //Act: Llamado del codigo a probar
        Mockito.when(service.analyzeScores(id)).thenThrow(ObtenerDiplomaException.class);
        //Assert: Comprobación de los resultados
        Assertions.assertThrows(ObtenerDiplomaException.class, ()->obtenerDiplomaController.analyzeScores(id));
    }
}
