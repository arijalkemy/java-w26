package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(1L, "Camila", List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Física", 4.0)
        ));
    }

    @Test
    void registerStudent() {
        studentController.registerStudent(studentDTO);
        verify(studentService, atLeastOnce()).create(studentDTO);
    }

    @Test
    void getStudent() {
        studentController.getStudent(studentDTO.getId());
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);

        assertEquals(studentDTO, studentController.getStudent(studentDTO.getId()));
    }

    @Test
    void modifyStudent() {
        studentController.modifyStudent(studentDTO);
        verify(studentService, atLeastOnce()).update(studentDTO);
    }

    @Test
    void removeStudent() {
        studentController.removeStudent(studentDTO.getId());
        verify(studentService, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void listStudents() {
        Set<StudentDTO> studentExpected = new HashSet<>();
        studentExpected.add(studentDTO);
        when(studentService.getAll()).thenReturn(studentExpected);

        Set<StudentDTO> studentsActual = studentController.listStudents();

        assertEquals(studentExpected, studentsActual);

    }
}