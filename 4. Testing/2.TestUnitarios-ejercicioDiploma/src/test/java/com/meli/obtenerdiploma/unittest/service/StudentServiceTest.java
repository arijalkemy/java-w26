package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("Tests para StudentService")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO mockStudent;

    @BeforeEach
    void setUp() {
        mockStudent = new StudentDTO();
        mockStudent.setStudentName("Juan");
        mockStudent.setId(1L);
        mockStudent.setAverageScore(8.0);
        SubjectDTO matematicas = new SubjectDTO("matematicas", 8.0);
        SubjectDTO biologia = new SubjectDTO("biologia", 8.0);
        SubjectDTO espanol = new SubjectDTO("español", 8.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(matematicas);
        subjects.add(biologia);
        subjects.add(espanol);
        mockStudent.setSubjects(subjects);

    }
    @Test
    @DisplayName("test para crear un estudiante")
    void createStudentTest(){
        doNothing().when(studentDAO).save(mockStudent);
        studentService.create(mockStudent);
        verify(studentDAO, atLeast(1)).save(mockStudent);
    }

    @Test
    @DisplayName("test para leer un estudiante")
    void readStudentTest(){
        StudentDTO expected = mockStudent;
        when(studentDAO.findById(1L)).thenReturn(mockStudent);
        StudentDTO result = studentService.read(1L);
        verify(studentDAO, atLeast(1)).findById(1L);
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("test para crear un estudiante")
    void updateStudentTest(){
        doNothing().when(studentDAO).save(mockStudent);
        studentService.update(mockStudent);
        verify(studentDAO, atLeast(1)).save(mockStudent);
    }

    @Test
    @DisplayName("test para eliminar el estudiante con ID 1")
    void deleteStudentTest(){
        studentService.delete(1L);
        verify(studentDAO, atLeast(1)).delete(1L);
    }

    @Test
    @DisplayName("Test para obtener la lista de todos los estudiantes")
    void getAllStudentsTest(){
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(mockStudent);
        when(studentRepository.findAll()).thenReturn(expected);
        Set<StudentDTO> result = studentService.getAll();
        assertEquals(expected, result);
    }
}
