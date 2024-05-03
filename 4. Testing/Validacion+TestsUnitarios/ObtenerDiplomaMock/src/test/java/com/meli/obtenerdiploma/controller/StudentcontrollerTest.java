package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentcontrollerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    private StudentDTO studient;
    @BeforeEach
    public void setUp() {
        TestGenerator testGenerator = new TestGenerator();
        studient = testGenerator.getStudentDTO();
    }

    @Test
    public void registerStudent() {
        // arrange

        // act
        controller.registerStudent(studient);

        // assert
        verify(service, atLeastOnce()).create(studient)
        ;
    }

    @Test
    public void getStudent() {
        // arrange
        when(service.read(studient.getId())).thenReturn(studient);
        // act
        StudentDTO resultado = controller.getStudent(studient.getId());
        // assert
        verify(service, atLeastOnce()).read(studient.getId());
        assertEquals(studient, resultado);

    }

    @Test
    public void modifyStudent() {
        // arrange

        // act
        controller.modifyStudent(studient);
        // assert
        verify(service, atLeastOnce()).update(studient);
    }

    @Test
    public void removeStudent() {
        // arrange

        // act
        controller.removeStudent(studient.getId());
        // assert
        verify(service, atLeastOnce()).delete(studient.getId());
    }

    @Test
    public void listStudents() {
        // arrange
        TestGenerator testGenerator= new TestGenerator();
        Set<StudentDTO> students = testGenerator.findAll();
        when(service.getAll()).thenReturn(students);
        // act
        Set<StudentDTO> resultado=controller.listStudents();
        // assert
        verify(service, atLeastOnce()).getAll();
        assertEquals(students, resultado);
    }

}
