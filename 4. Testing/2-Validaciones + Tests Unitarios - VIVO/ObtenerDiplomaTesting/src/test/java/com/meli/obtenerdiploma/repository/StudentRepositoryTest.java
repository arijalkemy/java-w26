package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAllStudentsTest(){
        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        Assertions.assertFalse(students.isEmpty(), "The list of students should not be empty");
    }
}
