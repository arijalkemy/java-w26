package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAllReturnsThree(){
        var students = studentRepository.findAll();

        Assertions.assertTrue(students.size() == 2);
    }
}
