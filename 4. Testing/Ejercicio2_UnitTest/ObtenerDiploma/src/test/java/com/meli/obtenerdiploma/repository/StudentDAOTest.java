package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.utils.StudentGeneratorTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.mockito.Mockito.*;

class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        this.studentDAO = new StudentDAO();
    }

    @DisplayName("Test - Guardar estudiante nuevo")
    @Test
    void saveNewStudent() {
        // Arrange
        StudentDTO studentDTO = StudentGeneratorTest.getStudentForTest();

        // Act
        studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
        Assertions.assertEquals(3L, studentDTO.getId());
        Assertions.assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }

    @DisplayName("Test - Guardar estudiante existente")
    @Test
    void saveExistStudent() {
        // Arrange
        StudentDTO studentDTO = StudentGeneratorTest.getStudentForTest();
        studentDTO.setId(1L);

        // Act
        studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
        Assertions.assertEquals(1L, studentDTO.getId());
        Assertions.assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }

    @DisplayName("Test - Probar estudiante existente")
    @Test
    void existStudent() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        studentDAO.save(student);
        // Act
        boolean result = studentDAO.exists(student);
        // Assertion
        Assertions.assertTrue(result);
    }

    @DisplayName("Test - Probar estudiante NO existente")
    @Test
    void nonExistentStudent() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        student.setId(999L);
        // Act
        boolean result = studentDAO.exists(student);
        // Assertion
        Assertions.assertFalse(result);
    }

    @DisplayName("Test - Obtener estudiante existente por id")
    @Test
    void getStudentById() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        studentDAO.save(student);
        // Act
        StudentDTO studentObtained = studentDAO.findById(student.getId());
        // Assertion
        Assertions.assertEquals(student, studentObtained);
    }

    @DisplayName("Test - Obtener estudiante No existente por id")
    @Test
    void getStudentByIdNonExistent() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        student.setId(999L);
        // Act - Assertion
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId()));
    }

    @DisplayName("Test - Eliminar estudiante existente")
    @Test
    void deleteStudent() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        studentDAO.save(student);
        // Act
        boolean result = studentDAO.delete(student.getId());
        // Assertion
        Assertions.assertTrue(result);
    }

    @DisplayName("Test - Eliminar estudiante No existente")
    @Test
    void deleteNonExistentStudent() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        student.setId(999L);
        // Act
        boolean result = studentDAO.exists(student);
        // Assertion
        Assertions.assertFalse(result);
    }

}