package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    @DisplayName("Test para ver si el usuario es creado de manera exitosa")
    void create() {
        //ARRANGE
        StudentDTO student = createSampleStudent();
        //ACT
        studentService.create(student);
        //ASSERT
        verify(studentDAO,atLeastOnce()).save(student);
    }

    @Test
    void read() {
        //ARRANGE
        StudentDTO studentDTO = createSampleStudent();
        //ACT
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO response =  studentService.read(1L);
        //ASSERT
        assertEquals(studentDTO,response);
        verify(studentDAO,atLeastOnce()).findById(1L);
    }


    private StudentDTO createSampleStudent(){
        SubjectDTO subject1 = new SubjectDTO("Matemáticas", 8.5);
        SubjectDTO subject2 = new SubjectDTO("Historia", 7.2);
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", "¡Felicidades por tus logros!", 7.85, Arrays.asList(subject1, subject2));
        return student;
    }
}