package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = TestUtilsGenerator.getStudentWithId(1L);
    }

    @Test
    @DisplayName("Create or Update student successfully")
    void createOrUpdateStudentTest() {
        // act
        studentService.create(studentDTO);

        // assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("Read student by ID")
    void readStudentByIDTest() {
        // arrange
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //act
        StudentDTO resultStudentDTO = studentService.read(studentDTO.getId());

        // assert
        verify(studentDAO).findById(studentDTO.getId());
        assertEquals(studentDTO.getId(), resultStudentDTO.getId());
        assertEquals(studentDTO.getStudentName(), resultStudentDTO.getStudentName());
        assertEquals(studentDTO.getSubjects(), resultStudentDTO.getSubjects());
        assertEquals(studentDTO.getAverageScore(), resultStudentDTO.getAverageScore());
    }

    @Test
    @DisplayName("Read student with student not found exception")
    void readStudentTest_StudentNotFoundException() {
        // arrange
        when(studentDAO.findById(studentDTO.getId())).thenThrow(StudentNotFoundException.class);

        //act and assert
        Long studentId = studentDTO.getId();
        assertThrows(StudentNotFoundException.class,
                () -> studentService.read(studentId));
        verify(studentDAO, atLeastOnce()).findById(studentId);
    }

    @Test
    @DisplayName("Delete student by id")
    void deleteStudentTest() {
        // act
        studentService.delete(studentDTO.getId());

        // assert
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    @DisplayName("Get all students")
    void getAllStudentsTest() {
        // arrange
        Set<StudentDTO> studentDTOs = TestUtilsGenerator.getStudentSet();
        when(studentRepository.findAll()).thenReturn(studentDTOs);

        // act
        Set<StudentDTO> resultStudentDTOs = studentService.getAll();

        // assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertIterableEquals(studentDTOs, resultStudentDTOs);
    }

    @Test
    @DisplayName("Get empty student list")
    void getEmptyStudentListTest() {
        // arrange
        when(studentRepository.findAll()).thenReturn(new HashSet<>());

        // act
        Set<StudentDTO> resultStudentDTOs = studentService.getAll();

        // assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertTrue(resultStudentDTOs.isEmpty());
    }
}