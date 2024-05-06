package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    public void registerStudent() {
        // arrange
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        // act
        controller.registerStudent(student);

        // assert
        verify(service, atLeastOnce()).create(student);
    }

    @Test
    public void getStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        when(service.read(student.getId())).thenReturn(student);

        StudentDTO readStu = controller.getStudent(student.getId());

        verify(service, atLeastOnce()).read(student.getId());
        assertEquals(student, readStu);
    }

    @Test
    public void modifyStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        controller.modifyStudent(student);

        verify(service, atLeastOnce()).update(student);
    }

    @Test
    public void removeStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        controller.removeStudent(student.getId());

        verify(service, atLeastOnce()).delete(student.getId());
    }

    @Test
    public void listStudents() {
        Set<StudentDTO> students = new HashSet<>(Collections.singletonList(new StudentDTO()));

        when(service.getAll()).thenReturn(students);

        Set<StudentDTO> readStudents = controller.listStudents();

        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}
