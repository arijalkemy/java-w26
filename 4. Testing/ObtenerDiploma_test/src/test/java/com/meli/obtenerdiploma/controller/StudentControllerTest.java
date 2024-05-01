package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService service;
    @InjectMocks
    StudentController diplomaController;
    Set<StudentDTO> studentList;

    @BeforeEach
    void setup() {
        studentList = StudentsUtils.getMockStudents();
        StudentDTO aStudent = studentList.iterator().next();
        Mockito.lenient().when(service.read(1L)).thenReturn(aStudent);
        Mockito.lenient().when(service.getAll()).thenReturn(studentList);
    }

    @Test
    @DisplayName("Test to register a new user")
    void registerStudentTest() {
        // Given - Arrange
        StudentDTO expectedStudent = studentList.iterator().next();

        // When - Act
        ResponseEntity<?> someStudent = diplomaController.registerStudent(expectedStudent);

        // Then - Assert
        Assertions.assertEquals(HttpStatus.OK, someStudent.getStatusCode());
    }

    @Test
    @DisplayName("Getting a user by id")
    void getStudentTest() {
        // Given - Arrange
        StudentDTO expectedStudent = studentList.iterator().next();

        // When - Act
        StudentDTO responseStudent = diplomaController.getStudent(1L);

        // Then - Assert
        Assertions.assertEquals(expectedStudent, responseStudent);
    }

    @Test
    @DisplayName("Get all the students")
    void getAllStudentsTest() {
        // Given - Arrange
        // When - Act
        Set<StudentDTO> responseStudent = diplomaController.listStudents();

        // Then - Assert
        Assertions.assertEquals(studentList, responseStudent);
    }
}
