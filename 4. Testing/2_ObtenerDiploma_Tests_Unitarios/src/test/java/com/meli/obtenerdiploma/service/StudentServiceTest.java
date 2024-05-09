package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Estos tests no analizan los casos de fallo de los métodos,
 * porque el manejo de estos casos de fallo están hechos en el DAO,
 * y el DAO ya tiene tests de que esos fallos se manejen de forma correcta.
 */
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void createOk() {

        StudentDTO student = StudentUtils.createCommonStudent(null);

        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void readOk() {

        long studentId = 1;
        StudentDTO student = StudentUtils.createCommonStudent(studentId);

        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO foundStudent = studentService.read(studentId);

        assertThat(foundStudent).isEqualTo(student);
    }

    @Test
    public void updateOk() {

        StudentDTO student = StudentUtils.createCommonStudent(1L);

        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void deleteOk() {

        long studentId = 1;

        when(studentDAO.delete(studentId)).thenReturn(true);

        studentService.delete(studentId);
    }

    @Test
    public void getAll() {

        Set<StudentDTO> expectedStudents = StudentUtils.createTestStudents();

        when(studentRepository.findAll()).thenReturn(StudentUtils.createTestStudents());

        Set<StudentDTO> actualStudents = studentService.getAll();

        assertThat(actualStudents).isEqualTo(expectedStudents);
    }
}