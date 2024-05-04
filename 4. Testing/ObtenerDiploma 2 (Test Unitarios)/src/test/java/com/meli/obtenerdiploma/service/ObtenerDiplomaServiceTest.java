package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    private StudentDTO estudianteEsperado;

    @BeforeEach
    private void setup(){
        this.estudianteEsperado = new StudentDTO();
        List<SubjectDTO> listaMaterias = List.of( new SubjectDTO("Espaniol", 9.5));

        estudianteEsperado.setSubjects(listaMaterias);
        estudianteEsperado.setStudentName("Luis");
    }

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Los datos son los esperados a la salida")
    void entradaIgualALaSalida(){


        when(iStudentDAO.findById((long)3)).thenReturn(estudianteEsperado);

        StudentDTO estudianteObtenido = obtenerDiplomaService.analyzeScores((long)3);

        Assertions.assertEquals(estudianteEsperado,estudianteObtenido);


    }

    @Test
    @DisplayName("El promedio debe ser 9.5")
    void calculoPromedio(){

        when(iStudentDAO.findById((long)3)).thenReturn(estudianteEsperado);

        StudentDTO estudianteObtenido = obtenerDiplomaService.analyzeScores((long)3);

        Assertions.assertEquals(estudianteEsperado.getAverageScore(),estudianteObtenido.getAverageScore());

    }

    @Test
    @DisplayName("La leyenda del mensaje de salida es la esperada")
    void leyendaDelMensaje() {

        //aqui deberia ser la declaracion de otro alumno con un promedio especifico que sea menor a 9

        when(iStudentDAO.findById((long)3)).thenReturn(estudianteEsperado);

        StudentDTO estudianteObtenido = obtenerDiplomaService.analyzeScores((long)3);

        Assertions.assertEquals("El alumno Luis ha obtenido un promedio de 9.0. Puedes mejorar.", estudianteObtenido.getMessage());
    }

    @Test
    @DisplayName("La leyenda de honores es la esperada")
    void leyendaDelMensajeConHonores() {

        when(iStudentDAO.findById((long)3)).thenReturn(estudianteEsperado);

        StudentDTO estudianteObtenido = obtenerDiplomaService.analyzeScores((long)3);

        Assertions.assertEquals("El alumno Luis ha obtenido un promedio de 9.5. Felicitaciones!", estudianteObtenido.getMessage());
    }


}
