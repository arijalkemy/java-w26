package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    //ejercicio 5
    @Mock
    IStudentService serviceStu;

    @InjectMocks
    StudentController controllerStu;

    private StudentDTO stu;
    private HashSet<StudentDTO> students;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        stu = new StudentDTO(1L, "John Doe","message",8D,
                List.of(
                        new SubjectDTO("Math", 10D),
                        new SubjectDTO("Science", 9D),
                        new SubjectDTO("History", 8D)));
        students = new HashSet<>();
        students.add(stu);
    }

    @Test
    void registerStudent() {
        controllerStu.registerStudent(stu);

        verify(serviceStu, atLeastOnce()).create(stu);
    }

    @Test
    void getStudent() {
        // arrange
        when(serviceStu.read(stu.getId())).thenReturn(stu);
        // act
        StudentDTO readStu = controllerStu.getStudent(stu.getId());
        // assert
        verify(serviceStu, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    void modifyStudent() {
        controllerStu.modifyStudent(stu);

        verify(serviceStu, atLeastOnce()).update(stu);
    }

    @Test
    void removeStudent() {
        // act
        controllerStu.removeStudent(stu.getId());
        // assert
        verify(serviceStu, atLeastOnce()).delete(stu.getId());

    }

    @Test
    void listStudents() {
        // arrange
        when(serviceStu.getAll()).thenReturn(students);
        // act
        Set<StudentDTO> listStu = controllerStu.listStudents();
        // assert
        verify(serviceStu, atLeastOnce()).getAll();
        assertEquals(students, listStu);

    }
}