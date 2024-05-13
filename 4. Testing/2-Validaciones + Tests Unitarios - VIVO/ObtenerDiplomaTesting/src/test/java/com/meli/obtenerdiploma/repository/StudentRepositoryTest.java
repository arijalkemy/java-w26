package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import net.bytebuddy.jar.asm.TypeReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();


       @Test
    @DisplayName("Should return all students")
    void findAllTest() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new ClassPathResource("users.json").getFile();


        // Act
        Set<StudentDTO> actualStudents = studentRepository.findAll();

        // Assert
        assertEquals(expectedStudents.size(), actualStudents.size());
    }

}
