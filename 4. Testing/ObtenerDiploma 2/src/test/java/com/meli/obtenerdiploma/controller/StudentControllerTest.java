package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", 8.0)));
        ResponseEntity<?> responseExpected = ResponseEntity.ok(null);

        ResponseEntity<?> result = studentController.registerStudent(studentDTO);

        Assertions.assertEquals(responseExpected, result);
    }

    @Test
    void getStudentTest() {
        StudentDTO expectedStudentDTO = new StudentDTO();
        expectedStudentDTO.setId(1L);

        when(studentService.read(1L)).thenReturn(expectedStudentDTO);

        StudentDTO resultStudentDTO = studentController.getStudent(1L);

        Assertions.assertEquals(expectedStudentDTO, resultStudentDTO);
    }

    @Test
    void modifyStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test");

        ResponseEntity<?> responseExpected = ResponseEntity.ok(null);

        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);

        verify(studentService, atLeast(1)).update(studentDTO);
        Assertions.assertEquals(responseExpected, result);
    }

    @Test
    void removeStudentTest() {
        ResponseEntity<?> responseExpected = ResponseEntity.ok(null);

        ResponseEntity<?> result = studentController.removeStudent(1L);

        verify(studentService, atLeast(1)).delete(1L);
        Assertions.assertEquals(responseExpected, result);
    }

    @Test
    void listStudentsTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test");

        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setStudentName("Test1");

        Set<StudentDTO> expectedStudents = Set.of(studentDTO1, studentDTO);

        when(studentService.getAll()).thenReturn(expectedStudents);

        Set<StudentDTO> resultStudents = studentController.listStudents();

        Assertions.assertEquals(expectedStudents, resultStudents);
    }
}