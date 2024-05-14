package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {
    StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    public void findAllTest() {
        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        Assertions.assertEquals(6, students.size());
    }
}
