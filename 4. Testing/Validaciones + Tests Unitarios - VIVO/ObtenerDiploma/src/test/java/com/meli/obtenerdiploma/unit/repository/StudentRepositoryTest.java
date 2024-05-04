package com.meli.obtenerdiploma.unit.repository;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.StudentBuilder;

@ActiveProfiles("test")
public class StudentRepositoryTest {

    private StudentRepository repositoryToTest;


    @BeforeEach
    public void beforeEachTest()
    {
        this.repositoryToTest = new StudentRepository();
    }

    @Test
    @DisplayName("Test if get all Students from JSON")
    public void findAllTest()
    {
        //Arrage
        Set<StudentDTO> expected = StudentBuilder.studentsFromJSON();

        //Act
        Set<StudentDTO> result = repositoryToTest.findAll();
        
        //Asserts

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertEquals(expected, result);
        
        /*
         * Nota #1:
         * El assert de (Tamaño y Objeto) aunque puede estar bienm, cuando se cambia el JSON no funciona
         * de manera que, podria ser que se esta haciendo una validacion incorrecta, porque
         * de igual manera se esta recuperando los datos.
         * Lo que yo pienso es que el tamaño quizas no es un buena variable para medir sí se esta ejecutando
         * o no la acción de findAll().
         * De hecho en principio le agrega mas complejidad
         */
    }
}
