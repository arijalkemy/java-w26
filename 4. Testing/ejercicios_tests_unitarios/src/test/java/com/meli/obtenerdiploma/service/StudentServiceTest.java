package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
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

    @BeforeEach
    void setUp() {
        //students = TestUtilsGenerator.getStudentsSet();
    }

    @Test
    public void createStudentOkTest() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, atLeast(1)).save(any());
    }

    @Test
    public void readStudentOkTest() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = studentService.read(student.getId());

        // Assert
        Assertions.assertEquals(student, result);
    }

    @Test
    public void readStudentNotFoundExceptionTest() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        when(studentDAO.findById(1L)).thenThrow(StudentNotFoundException.class);

        // Act & Assert
        Assertions.assertThrows(
            StudentNotFoundException.class,
            () -> studentService.read(student.getId())
        );
    }

    @Test
    public void updateStudentOkTest() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, atLeast(1)).save(any());
    }

    @Test
    public void deleteStudentOkTest() {
        StudentDTO student = TestUtilsGenerator.getStudent();

        // Act
        studentService.delete(student.getId());

        // Assert
        verify(studentDAO, atLeast(1)).delete(any());
    }

    @Test
    public void deleteStudentNotFoundExceptionTest() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudent();
        when(studentDAO.delete(student.getId())).thenThrow(StudentNotFoundException.class);

        // Act & Assert
        Assertions.assertThrows(
            StudentNotFoundException.class,
            () -> studentService.delete(student.getId())
        );
    }

    @Test
    public void getAllOkTest() {
        // Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentsSet();
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        Assertions.assertEquals(students, result);
    }

    @Test
    public void getAllOkEmptyTest() {
        // Arrange
        Set<StudentDTO> students = new HashSet<>();
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        Assertions.assertEquals(students, result);
    }
}
