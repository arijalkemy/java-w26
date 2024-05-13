package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();

    @Test
    @DisplayName("Should return all students")
    void findAllTest1() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("./src/test/resources/users.json");
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});

        // Act
        Set<StudentDTO> actualStudents = studentRepository.findAll();

        // Assert
        assertEquals(expectedStudents, actualStudents);
    }



    @Test
    @DisplayName("Should return a FileNotFoundException when try findAllStudents and file not found")
    void findAllStudentsNotFoundFile() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();

        Set<StudentDTO> expectedStudents = new HashSet<>();


        // Act
        Set<StudentDTO> actualStudents = studentRepository.findAll();

        // Assert
        assertThrows(FileNotFoundException.class, () -> studentRepository.findAll());
    }


}
