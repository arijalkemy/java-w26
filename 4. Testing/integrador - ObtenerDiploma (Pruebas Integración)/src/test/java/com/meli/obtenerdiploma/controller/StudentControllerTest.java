package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    StudentDTO studentDTO;
    Set<StudentDTO> listStudentsDTO;
    @BeforeEach
    public void setup(){
        studentDTO = new StudentDTO(
                1L,
                "",
                null,
                null,
                List.of()
        );
        listStudentsDTO = new HashSet<>();
    }

    @Test
    public void registerStudentTest(){
        //Act
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);
        //Assert
        verify(iStudentService, atLeastOnce()).create(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void getStudentTest(){
        //Arrange
        Long id = 1L;
        //Act
        when(iStudentService.read(id)).thenReturn(studentDTO);
        StudentDTO response = studentController.getStudent(id);
        //Assert
        assertEquals(studentDTO, response);
    }

    @Test
    public void modifyStudentTest(){
        //Act
        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);
        //Assert
        verify(iStudentService, atLeastOnce()).update(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void removeStudentTest(){
        //Act
        Long id = 1L;
        ResponseEntity<?> response = studentController.removeStudent(id);

        //Assert
        verify(iStudentService, atLeastOnce()).delete(anyLong());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void listStudentsTest(){
        //Arrange
        Set<StudentDTO> response;
        //Act
        when(iStudentService.getAll()).thenReturn(listStudentsDTO);
        response = studentController.listStudents();
        //Assert
        assertEquals(listStudentsDTO, response);
    }






}
