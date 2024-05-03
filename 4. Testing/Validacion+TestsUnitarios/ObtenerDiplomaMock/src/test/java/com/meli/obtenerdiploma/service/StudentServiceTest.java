package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private TestGenerator testGenerator;
    private StudentDTO student;

    @BeforeEach
    public void setup() {
        testGenerator=new TestGenerator();
        student = testGenerator.getStudentDTO();
    }

    @Test
    public void testSave() {
        studentService.create(student);
        verify(studentDAO).save(student);
    }

    @Test
    public void testRead() {
        when(studentDAO.findById(1L)).thenReturn(student);

        Long id = 1L;
        studentService.read(id);
        verify(studentDAO).findById(id);
    }

    @Test
    public void testUpdate() {
        studentService.update(student);
        verify(studentDAO).save(student);
    }

    @Test
    public void testDelete() {
        Long id = 1L;
        studentService.delete(id);
        verify(studentDAO).delete(id);
    }

    @Test
    public void testGetAll() {
        Set<StudentDTO> students = testGenerator.findAll();
        when(studentRepository.findAll()).thenReturn(students);

        studentService.getAll();

        verify(studentRepository).findAll();
    }
}

