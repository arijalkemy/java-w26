package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        controller.registerStudent(stu);

        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    public void getStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);

        StudentDTO readStu = controller.getStudent(stu.getId());

        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        controller.modifyStudent(stu);

        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        controller.removeStudent(stu.getId());

        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents() {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        Set<StudentDTO> readStudents = controller.listStudents();

        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}
