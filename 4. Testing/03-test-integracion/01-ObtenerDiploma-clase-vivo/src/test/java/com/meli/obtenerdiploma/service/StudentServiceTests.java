package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService service;

    @Test
    public void createStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        service.create(stu);

        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    public void readStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        StudentDTO readStu = service.read(stu.getId());

        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void updateStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        service.update(stu);

        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    public void deleteStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        service.delete(stu.getId());

        verify(studentDAO, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void getAllStudents() {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(studentRepo.findAll()).thenReturn(students);

        Set<StudentDTO> readStudents = service.getAll();

        verify(studentRepo, atLeastOnce()).findAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}