package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();

        // Act
        doNothing().when(studentService).create(studentDTO);
        ResponseEntity<?> responseEntity = studentController.registerStudent(studentDTO);

        // Assert
        assertEquals(ResponseEntity.ok(null), responseEntity);
        verify(studentService, times(1)).create(studentDTO);
    }

    @Test
    public void getStudent() {
        // Arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO();

        // Act
        when(studentService.read(id)).thenReturn(studentDTO);

        // Assert
        assertEquals(studentDTO, studentController.getStudent(id));
        verify(studentService, times(1)).read(id);
    }

    @Test
    public void modifyStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();

        // Act
        doNothing().when(studentService).update(studentDTO);
        ResponseEntity<?> responseEntity = studentController.modifyStudent(studentDTO);

        // Assert
        assertEquals(ResponseEntity.ok(null), responseEntity);
        verify(studentService, times(1)).update(studentDTO);
    }

    @Test
    public void removeStudent() {
        // Arrange
        Long id = 1L;

        // Act
        doNothing().when(studentService).delete(1L);
        ResponseEntity<?> responseEntity = studentController.removeStudent(id);

        // Assert
        assertEquals(ResponseEntity.ok(null), responseEntity);
        verify(studentService, times(1)).delete(id);
    }

    @Test
    public void listStudents() {
        // Arrange
        Set<StudentDTO> studentDTOSet = new HashSet<>();

        // Act
        when(studentService.getAll()).thenReturn(studentDTOSet);

        // Assert
        assertEquals(studentDTOSet, studentController.listStudents());
        verify(studentService, times(1)).getAll();
    }

}
