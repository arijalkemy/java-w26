package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Register Student")
    public void registerStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(); // Provide necessary data for student
        Mockito.doNothing().when(studentService).create(studentDTO);

        // Act
        ResponseEntity<?> responseEntity = studentController.registerStudent(studentDTO);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Get Student")
    public void getStudent() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO(); // Provide necessary data for expected student
        Mockito.when(studentService.read(studentId)).thenReturn(expectedStudent);

        // Act
        StudentDTO result = studentController.getStudent(studentId);

        // Assert
        Assertions.assertEquals(expectedStudent, result);
    }

    @Test
    @DisplayName("Modify Student")
    public void modifyStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(); // Provide necessary data for student
        Mockito.doNothing().when(studentService).update(studentDTO);

        // Act
        ResponseEntity<?> responseEntity = studentController.modifyStudent(studentDTO);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Remove Student")
    public void removeStudent() {
        // Arrange
        Long studentId = 1L;
        Mockito.doNothing().when(studentService).delete(studentId);

        // Act
        ResponseEntity<?> responseEntity = studentController.removeStudent(studentId);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("List Students")
    public void listStudents() {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>(Arrays.asList(new StudentDTO(), new StudentDTO())); // Provide necessary data for expected students
        Mockito.when(studentService.getAll()).thenReturn(expectedStudents);

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        Assertions.assertEquals(expectedStudents, result);
    }

    // Add more tests as needed for edge cases, null inputs, etc.
}
