package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    private StudentDTO mockStudent;

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService service;

    @BeforeEach
    void setUp() {
        mockStudent = new StudentDTO();
        mockStudent.setStudentName("Test student");
        mockStudent.setId(1L);
    }

    @Test
    @DisplayName("Should create a student")
    void create() {
        // Act
        service.create(mockStudent);

        // Assert
        verify(studentDAO).save(mockStudent);
    }

    @Test
    @DisplayName("Should read a student")
    void read() {
        // Arrange
        Mockito.when(studentDAO.findById(1L)).thenReturn(mockStudent);

        // Act
        StudentDTO result = service.read(1L);

        // Assert
        assertEquals(mockStudent.getStudentName(), result.getStudentName());
    }

    @Test
    @DisplayName("Should update a student")
    void update() {
        // Act
        service.update(mockStudent);

        // Assert
        verify(studentDAO).save(mockStudent);
    }

    @Test
    @DisplayName("Should delete a student")
    void delete() {
        // Act
        service.delete(1L);

        // Assert
        verify(studentDAO).delete(1L);
    }

    @Test
    @DisplayName("Should get all students")
    void getAll() {
        // Arrange
        Set<StudentDTO> mockStudents = new HashSet<>();
        mockStudents.add(new StudentDTO(1L, "Test student 1", "Test student 1", 8.5, Arrays.asList(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0))));
        mockStudents.add(new StudentDTO(2L, "Test student 2", "Test student 2", 8.5, Arrays.asList(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0))));

        when(studentRepository.findAll()).thenReturn(mockStudents);

        // Act
        Set<StudentDTO> result = service.getAll();

        // Assert
        assertEquals(mockStudents, result);
    }
}