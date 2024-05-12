package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoTest {

    @Test
    public void testSave_NewStudent() {

        StudentDAO studentService = new StudentDAO();
        Long expectedId = 1L;
        String expectedName = "Juan";

        StudentDTO studentDTO = StudentDTO.builder()
                .id(expectedId)
                .studentName(expectedName)
                .subjects(Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.5),
                        new SubjectDTO("Español", 8.7),
                        new SubjectDTO("Ciencias", 9.2)
                ))
                .build();

        studentService.save(studentDTO);

        StudentDTO savedStudent = studentService.findById(expectedId);
        Assertions.assertEquals(savedStudent, studentDTO);

    }

    @Test
    public void testDelete_ExistingStudent() {
        // Arrange
        StudentDAO studentService = new StudentDAO();
        Long expectedId = 1L;
        String expectedName = "Juan";

        StudentDTO studentDTO = StudentDTO.builder()
                .id(expectedId)
                .studentName(expectedName)
                .subjects(Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.5),
                        new SubjectDTO("Español", 8.7),
                        new SubjectDTO("Ciencias", 9.2)
                ))
                .build();

        studentService.save(studentDTO);

        // Act
        boolean deleteResult = studentService.delete(expectedId);

        // Assert
        Assertions.assertTrue(deleteResult);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.findById(expectedId));
    }

    @Test
    public void testDelete_NonExistingStudent() {
        // Arrange
        StudentDAO studentService = new StudentDAO();
        Long nonExistingId = 100L;

        // Act
        boolean deleteResult = studentService.delete(nonExistingId);

        // Assert
        Assertions.assertFalse(deleteResult);
    }

    // Test para verificar si existe un estudiante
    @Test
    public void testExists_ExistingStudent() {
        // Arrange
        StudentDAO studentService = new StudentDAO();
        Long expectedId = 1L;
        String expectedName = "Juan";

        StudentDTO studentDTO = StudentDTO.builder()
                .id(expectedId)
                .studentName(expectedName)
                .subjects(Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.5),
                        new SubjectDTO("Español", 8.7),
                        new SubjectDTO("Ciencias", 9.2)
                ))
                .build();

        studentService.save(studentDTO);

        // Act
        boolean exists = studentService.exists(studentDTO);

        // Assert
        Assertions.assertTrue(exists);
    }

    // Test para verificar si no existe un estudiante
    @Test
    public void testExists_NonExistingStudent() {
        // Arrange
        StudentDAO studentService = new StudentDAO();
        Long nonExistingId = 100L;

        StudentDTO nonExistingStudent = StudentDTO.builder()
                .id(nonExistingId)
                .studentName("Non-existing")
                .subjects(Arrays.asList(
                        new SubjectDTO("Maths", 7.8),
                        new SubjectDTO("English", 6.5)
                ))
                .build();

        // Act
        boolean exists = studentService.exists(nonExistingStudent);

        // Assert
        Assertions.assertFalse(exists);
    }

    // Test para encontrar un estudiante existente por ID
    @Test
    public void testFindById_ExistingStudent() {
        // Arrange
        StudentDAO studentService = new StudentDAO();
        Long expectedId = 1L;
        String expectedName = "Juan";

        StudentDTO studentDTO = StudentDTO.builder()
                .id(expectedId)
                .studentName(expectedName)
                .subjects(Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.5),
                        new SubjectDTO("Español", 8.7),
                        new SubjectDTO("Ciencias", 9.2)
                ))
                .build();

        studentService.save(studentDTO);

        // Act
        StudentDTO foundStudent = studentService.findById(expectedId);

        // Assert
        Assertions.assertEquals(foundStudent, studentDTO);
    }

    // Test para encontrar un estudiante que no existe por ID
    @Test
    public void testFindById_NonExistingStudent() {
        // Arrange
        StudentDAO studentService = new StudentDAO();
        Long nonExistingId = 100L;

        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.findById(nonExistingId));
    }
}
