package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestingGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class studentDAORepositoryTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setup(){
        this.studentDAO = new StudentDAO();
    }



    @Test
    @DisplayName("Test - Alumno guardado de forma exitosa")
    public void guardarAlumno() {

        StudentDTO estudiante = TestingGeneratorUtil.devolverUnSoloEstudianteConNombreYLista();

        studentDAO.save(estudiante);

        Assertions.assertEquals(2, studentDAO.all().size());


    }

    @Test
    @DisplayName("Test - Borrando un alumno de la BD exitosamente")
    public void borrarUnAlumno(){
        Long id = 2L;

        studentDAO.delete(id);

        Assertions.assertEquals(1, studentDAO.all().size());
    }

    @Test
    @DisplayName("Test - Obtencion de un estudiante mediante su ID de manera exitosa")
    public void obtenerEstudianteConId() {
        StudentDTO estudianteEsperado = TestingGeneratorUtil.devolverUnSoloEstudianteConNombreYListaYID();

        StudentDTO estudianteObtenido = studentDAO.findById(estudianteEsperado.getId());

        Assertions.assertEquals(estudianteEsperado, estudianteObtenido);
    }
}
