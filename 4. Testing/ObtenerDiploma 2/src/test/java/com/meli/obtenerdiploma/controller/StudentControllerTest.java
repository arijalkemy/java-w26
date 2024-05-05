package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Register student successful")
    void registerStudentSuccessfulTest() {
        // arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);

        // act
        ResponseEntity<?> resultResponseEntity = studentController.registerStudent(studentDTO);

        // arrange
        verify(studentService, atLeastOnce()).create(studentDTO);
        assertNull(resultResponseEntity.getBody());
        assertEquals(HttpStatus.OK, resultResponseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Get student successful")
    void getStudentSuccessfulTest() {
        // arrange
        Long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(studentId);
        when(studentService.read(studentId)).thenReturn(studentDTO);

        // act
        StudentDTO resultStudentDTO = studentController.getStudent(studentId);

        // assert
        verify(studentService, atLeastOnce()).read(studentId);

        assertEquals(studentDTO.getId(), resultStudentDTO.getId());
        assertEquals(studentDTO.getStudentName(), resultStudentDTO.getStudentName());
        assertEquals(studentDTO.getSubjects(), resultStudentDTO.getSubjects());
        assertEquals(studentDTO.getAverageScore(), resultStudentDTO.getAverageScore());
    }

    @Test
    @DisplayName("Get student with StudentNotFoundException")
    void getStudentTest_StudentNotFoundException() {
        // arrange
        Long studentId = 9999L;
        when(studentService.read(studentId)).thenThrow(StudentNotFoundException.class);

        // act and assert
        assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(studentId));
        verify(studentService, atLeastOnce()).read(studentId);
    }

    @Test
    @DisplayName("Modify student successful")
    void modifyStudentSuccessful() {
        // arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);

        // act
        ResponseEntity<?> responseEntity = studentController.modifyStudent(studentDTO);

        // assert
        verify(studentService, atLeastOnce()).update(studentDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("Remove student by id successful")
    void removeStudentByIdTest() {
        // arrange
        Long studentId = 9999L;

        // act
        ResponseEntity<?> responseEntity = studentController.removeStudent(studentId);

        // assert
        verify(studentService, atLeastOnce()).delete(studentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("Get all list students successful")
    void getAllListStudentsTest() {
        // arrange
        Set<StudentDTO> studentDTOs = TestUtilsGenerator.getStudentSet();
        when(studentService.getAll()).thenReturn(studentDTOs);

        // act
        Set<StudentDTO> resultStudentDTOs = studentController.listStudents();

        // assert
        verify(studentService, atLeastOnce()).getAll();

        assertIterableEquals(studentDTOs, resultStudentDTOs);
    }

    @Test
    @DisplayName("Get empty list students")
    void getEmptyListStudents() {
        // arrange
        when(studentService.getAll()).thenReturn(new HashSet<>());

        // act
        Set<StudentDTO> resultStudentDTOs = studentController.listStudents();

        // assert
        verify(studentService, atLeastOnce()).getAll();

        assertEquals(new HashSet<>(), resultStudentDTOs);
        assertEquals(0, resultStudentDTOs.size());
    }

}