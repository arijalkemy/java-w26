package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.StudentGeneratorTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @DisplayName("Test - Caso exitoso del método Read")
    @Test
    void createTest() {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        // Act
        studentService.create(student);
        // Assert
        verify(studentDAO).save(any(StudentDTO.class));
    }

    @DisplayName("Test - Caso exitoso del método Read")
    @Test
    void readTest() {
        // Arrage
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        Long id = 1L;
        when(studentDAO.findById(id)).thenReturn(student);
        // Act
        StudentDTO studentObtenido =  studentService.read(id);
        // Assert
        verify(studentDAO).findById(any(Long.class));
        assertAll(
                () -> assertEquals(student.getStudentName(), studentObtenido.getStudentName()),
                () -> assertEquals(student.getSubjects(), studentObtenido.getSubjects()),
                () -> assertEquals(student.getAverageScore(), studentObtenido.getAverageScore()),
                () -> assertEquals(student.getId(), studentObtenido.getId()),
                () -> assertEquals(student, studentObtenido)
        );
    }

    @DisplayName("Test - Estudiante no éxiste método Read")
    @Test
    void studentDoesNotExistReadTest() {
        // Arrage
        Long id = 1L;
        when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);
        // Act - Assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(id));
        verify(studentDAO).findById(any(Long.class));
    }

    @DisplayName("Test - Actualizar Estudiante")
    @Test
    void updateTest() {
        // Arrage
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        // Act
        studentService.update(student);
        // Assert
        verify(studentDAO).save(any(StudentDTO.class));
    }

    @DisplayName("Test - Eliminar estudiante")
    @Test
    void deleteTest() {
        // Arrage
        Long id = 1L;
        // Act
        studentService.delete(id);
        // Assert
        verify(studentDAO).delete(any(Long.class));
    }

    @Test
    void getAllTest() {
        // Arrage
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(
                1L, "Cristopher", "Message", 5.5,
                List.of(new SubjectDTO("Matemáticas", 4.5),new SubjectDTO("Sociales", 6.5))
        ));
        students.add(new StudentDTO(
                2L, "Paula", "Message", 5.5,
                List.of(new SubjectDTO("Matemáticas", 4.5),new SubjectDTO("Sociales", 6.5))
        ));
        when(studentRepository.findAll()).thenReturn(students);
        // Act
        Set<StudentDTO> studentsObtained =  studentService.getAll();
        // Assert
        assertEquals(students, studentsObtained);
    }
}