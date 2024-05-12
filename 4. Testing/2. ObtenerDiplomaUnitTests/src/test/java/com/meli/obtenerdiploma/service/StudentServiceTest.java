package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create Student")
    public void createStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(); // Provide necessary data for student
        Mockito.doNothing().when(studentDAO).save(studentDTO);

        // Act
        studentService.create(studentDTO);

        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Read Student")
    public void readStudent() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO(); // Provide necessary data for expected student
        Mockito.when(studentDAO.findById(anyLong())).thenReturn(expectedStudent);

        // Act
        StudentDTO result = studentService.read(studentId);

        // Assert
        Assertions.assertEquals(expectedStudent, result);
    }

    @Test
    @DisplayName("Update Student")
    public void updateStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(); // Provide necessary data for student
        Mockito.doNothing().when(studentDAO).save(studentDTO);

        // Act
        studentService.update(studentDTO);

        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Delete Student")
    public void deleteStudent() {
        // Arrange
        Long studentId = 1L;
        Mockito.doReturn(true).when(studentDAO).delete(studentId);

        // Act
        studentService.delete(studentId);

        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).delete(studentId);
    }

    @Test
    @DisplayName("Get All Students")
    public void getAllStudents() {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>(Arrays.asList(new StudentDTO(), new StudentDTO())); // Provide necessary data for expected students
        Mockito.when(studentRepository.findAll()).thenReturn(expectedStudents);

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        Assertions.assertEquals(expectedStudents, result);
    }

}
