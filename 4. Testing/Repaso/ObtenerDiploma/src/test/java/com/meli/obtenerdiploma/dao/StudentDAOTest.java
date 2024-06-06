package com.meli.obtenerdiploma.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {
    @Autowired
    private StudentDAO studentDAO;

    @BeforeAll
    static void setup() {
        File file;

        try {
            file = ResourceUtils.getFile("./src/test/resources/users.json");
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void cleanup() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/test/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadedData.stream().forEach(s -> studentDAO.delete(s.getId()));
    }

    @Test
    @DisplayName("Should save students correctly")
    void saveStudentOkTest() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Estudiante nuevo", null, null, new ArrayList<>());
        // Act
        studentDAO.save(student);
        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Should delete students correctly")
    void deleteStudentOkTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Estudiante nuevo", null, null, new ArrayList<>());
        studentDAO.save(student);

        // Act
        studentDAO.delete(studentId);

        // Assert
        assertFalse(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Should not delete students if no id is provided")
    void deleteStudentsNullIdTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Estudiante nuevo", null, null, new ArrayList<>());
        studentDAO.save(student);

        // Act
        studentDAO.delete(null);

        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Should not delete students if id is not present")
    void deleteStudentsInvalidIdTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Estudiante nuevo", null, null, new ArrayList<>());
        studentDAO.save(student);

        // Act
        studentDAO.delete(2L);

        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Should return true if student exists")
    void studentExistsTest(){
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Estudiante nuevo", null, null, new ArrayList<>());
        studentDAO.save(student);

        // Act & assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Should return false if student does not exist")
    void studentDoesNotExistsTest(){
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Estudiante nuevo", null, null, new ArrayList<>());

        // Act & assert
        assertFalse(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Should return student if exists")
    void findByIdTest(){
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Estudiante nuevo", null, null, new ArrayList<>());
        studentDAO.save(student);

        // Act & assert
        assertEquals(student, studentDAO.findById(studentId));
    }

    @Test
    @DisplayName("Should throw exception if student does not exist")
    void findByIdNullTest(){
        // Act & assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

}
