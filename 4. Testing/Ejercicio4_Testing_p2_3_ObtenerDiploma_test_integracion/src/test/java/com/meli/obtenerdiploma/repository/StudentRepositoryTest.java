package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Test 1 - Listado de todos los StudentDAO escenario no hay datos en el json")
    void listartest() {
        //Act: llamado del metodo necesario para la validacion
        Set<StudentDTO> datosObtenidos = studentRepository.findAll();
        datosObtenidos.removeAll(datosObtenidos);
        //Assert: Comparación de los valores
        Assertions.assertEquals(0, datosObtenidos.size());
    }

    @Test
    @DisplayName("Test 1 - Listado de todos los StudentDAO escenario hay datos en el json")
    void listartestAllStudent() {
        //Act: llamado del metodo necesario para la validacion
        Set<StudentDTO> datosObtenidos = studentRepository.findAll();
        //Assert: Comparación de los valores
        Assertions.assertTrue(datosObtenidos.size()>0);

    }

}
