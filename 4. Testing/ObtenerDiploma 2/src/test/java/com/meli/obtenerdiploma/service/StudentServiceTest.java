package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void sePuedeCrearUnEstudianteTest() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("John Doe");
        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void readReturnsCorrectStudentTest() {
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(1L);
        expectedStudent.setStudentName("John Doe");
        when(studentDAO.findById(1L)).thenReturn(expectedStudent);

        StudentDTO actualStudent = studentService.read(1L);

        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void updateSavesStudentTest() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("John Doe");

        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void deleteStudentTest() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("John Doe");
        student.setId(1L);

        studentService.delete(1L);

        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    public void getAllReturnsAllStudentsTest() {
        StudentDTO john = new StudentDTO();
        StudentDTO jane = new StudentDTO();
        john.setStudentName("John Doe");
        john.setId(1L);
        jane.setStudentName("Jane Smith");
        jane.setId(2L);

        Set<StudentDTO> expectedStudents = Set.of(
                john,
                jane
        );
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        Set<StudentDTO> actualStudents = studentService.getAll();

        assertEquals(expectedStudents, actualStudents);
    }
}
