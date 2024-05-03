package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    void findAllTest() {
        // Act
        Set<StudentDTO> loadedData = studentRepository.findAll();
        // Assert
        org.assertj.core.api.Assertions.assertThat(loadedData).isNotNull();
        org.assertj.core.api.Assertions.assertThat(loadedData).isNotEmpty();
        org.assertj.core.api.Assertions.assertThat(loadedData.size()).isGreaterThanOrEqualTo(2);
    }
}