package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static com.meli.obtenerdiploma.util.UtilStudentGenerator.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class ObtenerDiplomaServiceTest {

    //creo mock de instancia studentdao
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Get congratulations greeting")
    public void congratulationsGreetings(){
        //datos de prueba
        StudentDTO studentDTO = studentWithAbove9Average("Juan Perez",1L);

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //se ejecuta el metodo que se quiere probar
        StudentDTO student = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        //se verifica el resultado
        assertEquals(9.9, student.getAverageScore());
        String expectedMessage = "El alumno Juan Perez ha obtenido un promedio de 9.9. Felicitaciones!";
        assertEquals(expectedMessage, student.getMessage());

    }

    @Test
    @DisplayName("Get you need to improve greeting")
    public void getBetterGreetings(){
        //datos de prueba
        StudentDTO studentDTO = studentWithBelow9Average("Juan Perez",1L);

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //se ejecuta el metodo que se quiere probar
        StudentDTO student = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        //se verifica el resultado
        assertEquals(7.0, student.getAverageScore());
        String expectedMessage = "El alumno Juan Perez ha obtenido un promedio de 7. Puedes mejorar.";
        assertEquals(expectedMessage, student.getMessage());

    }


}
