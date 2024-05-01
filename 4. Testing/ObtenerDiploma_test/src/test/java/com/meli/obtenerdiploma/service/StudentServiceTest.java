package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.StudentsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    Set<StudentDTO> studentList;

    @BeforeEach
    void setup() {
        studentList = StudentsUtils.getMockStudents();
        StudentDTO aStudent = studentList.iterator().next();
        Mockito.lenient().when(studentDAO.findById(1L)).thenReturn(aStudent);
        Mockito.lenient().when(studentRepository.findAll()).thenReturn(studentList);
    }

    @Test
    @DisplayName("Test to read a user")
    void readOkService() {
        // Given - Arrange
        StudentDTO expectedStudent = studentList.iterator().next();

        // When - Act
        StudentDTO someStudent = studentService.read(1L);

        // Then - Assert
        Assertions.assertEquals(expectedStudent, someStudent);
    }

    @Test
    @DisplayName("Get all the students")
    void getAllStudentsOk() {
        // Given - Arrange
        Set<StudentDTO> expectedStudentList = studentList;

        // When - Act
        Set<StudentDTO> resultStudentList = studentService.getAll();

        // Then - Assert
        Assertions.assertEquals(expectedStudentList, resultStudentList);
    }
}
