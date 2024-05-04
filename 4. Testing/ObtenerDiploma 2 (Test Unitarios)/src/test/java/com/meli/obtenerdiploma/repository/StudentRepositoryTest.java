package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestingGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    StudentRepository repository = new StudentRepository();

    @Test
    @DisplayName("Obtencion de todos los estudiantes de forma exitosa")
    public void findAll(){
        Set<StudentDTO> listaEsperada = TestingGeneratorUtil.setDeEstudiantesInJSON();

        Set<StudentDTO> listaObtenida = repository.findAll();

        Assertions.assertEquals(listaEsperada, listaObtenida);
    }
}
