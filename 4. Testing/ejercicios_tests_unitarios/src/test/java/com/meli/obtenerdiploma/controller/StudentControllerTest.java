package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    }

    @Test
    public void registerStudentOk() throws Exception {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        ResponseEntity<?> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);

        // Act
        ResponseEntity<?> result = studentController.registerStudent(student);

        // Assert
        verify(studentService, atLeast(1)).create(any());
        Assertions.assertEquals(
            writer.writeValueAsString(expectedResult),
            writer.writeValueAsString(result)
        );
    }

    @Test
    public void getStudentOk() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        when(studentService.read(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = studentController.getStudent(student.getId());

        // Assert
        verify(studentService, atLeast(1)).read(any());
        Assertions.assertEquals(student, result);
    }

    @Test
    public void modifyStudentOk() throws Exception {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        ResponseEntity<?> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);

        // Act
        ResponseEntity<?> result = studentController.modifyStudent(student);

        // Assert
        verify(studentService, atLeast(1)).update(any());
        Assertions.assertEquals(
            writer.writeValueAsString(expectedResult),
            writer.writeValueAsString(result)
        );
    }

    @Test
    public void removeStudentOk() throws Exception {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        ResponseEntity<?> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);

        // Act
        ResponseEntity<?> result = studentController.removeStudent(student.getId());

        // Assert
        verify(studentService, atLeast(1)).delete(any());
        Assertions.assertEquals(
            writer.writeValueAsString(expectedResult),
            writer.writeValueAsString(result)
        );
    }

    @Test
    public void listStudentsOk() {
        // Arrange
        Set<StudentDTO> expectedStudents = TestUtilsGenerator.getStudentsSet();
        when(studentService.getAll()).thenReturn(expectedStudents);

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        Assertions.assertEquals(expectedStudents, result);
    }
}
