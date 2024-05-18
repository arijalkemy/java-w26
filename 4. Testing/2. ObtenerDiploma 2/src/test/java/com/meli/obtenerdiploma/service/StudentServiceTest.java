package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void testCreateStudent() {
        StudentDTO student = new StudentDTO(1L, "John Doe", null, null, null);
        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void testReadStudent() {
        StudentDTO student = new StudentDTO(1L, "John Doe", null, null, null);
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO found = studentService.read(1L);

        assertEquals(student, found);
    }

    @Test
    public void testUpdateStudent() {
        StudentDTO student = new StudentDTO(1L, "John Doe", null, null, null);
        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void testDeleteStudent() {
        studentService.delete(1L);

        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    public void testGetAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "John Doe", null, null, null));
        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> found = studentService.getAll();

        assertEquals(students, found);
    }
}