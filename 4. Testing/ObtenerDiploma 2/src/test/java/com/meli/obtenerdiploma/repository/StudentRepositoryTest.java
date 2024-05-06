package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
public class StudentRepositoryTest {



    @Test
    public void findAllTest(){

        StudentRepository studentRepository = new StudentRepository();

        Set<StudentDTO> listStudents = studentRepository.findAll();

        Assertions.assertEquals(listStudents.size(),2);

    }

}
