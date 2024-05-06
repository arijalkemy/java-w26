package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.GenerateStudentsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    StudentDTO studentDTO;

    @BeforeEach
    public void setUp(){
        studentDTO = GenerateStudentsTest.generateStudent();
    }

    @Test
    public void testRegisterStudent(){
        controller.registerStudent(studentDTO);

        verify(service, atLeastOnce()).create(studentDTO);
    }

    @Test
    public void testGetStudent(){
        when(service.read(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO studentResponse = controller.getStudent(studentDTO.getId());

        verify(service, atLeastOnce()).read(studentDTO.getId());
        assertEquals(studentDTO, studentResponse);
    }

    @Test
    public void testModifyStudent(){
        controller.modifyStudent(studentDTO);

        verify(service, atLeastOnce()).update(studentDTO);
    }

    @Test
    public void testRemoveStudent(){
        controller.removeStudent(studentDTO.getId());

        verify(service, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    public void testListStudents(){
        Set<StudentDTO> students = GenerateStudentsTest.generateStudents();
        when(service.getAll()).thenReturn(students);

        Set<StudentDTO> studentsResponse = controller.listStudents();

        verify(service, atLeastOnce()).getAll();
        assertEquals(students, studentsResponse);
    }
}
