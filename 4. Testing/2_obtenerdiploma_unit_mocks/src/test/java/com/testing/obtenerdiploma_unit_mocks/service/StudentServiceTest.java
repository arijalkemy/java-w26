package com.testing.obtenerdiploma_unit_mocks.service;

import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;
import com.testing.obtenerdiploma_unit_mocks.repository.IStudentDAO;
import com.testing.obtenerdiploma_unit_mocks.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentRepository studentRepository;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    void create() {
        // arrange
        StudentDTO studentDTO = new StudentDTO(
                0L,
                "Pepito",
                null,
                null,
                List.of()
        );

        // act & assert
        this.studentService.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void readKnownStudent() {
        // Arrange
        Long id = 1L;

        StudentDTO studentDTO = new StudentDTO(
                1L, "Pepito", null, null, List.of()
        );

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        // Act
        StudentDTO response = this.studentService.read(id);

        // Assert
        Assertions.assertEquals(id, response.getId());
    }

    @Test
    void deleteNotAValidStudent() {
        Long id = 100L;
        this.studentService.delete(id);
        verify(studentDAO).delete(id);
    }

    @Test
    void getAllStudents() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L, "Pepito", null, null, List.of()
        );

        when(studentRepository.findAll()).thenReturn(Set.of(studentDTO));

        // Act
        Set<StudentDTO> results = this.studentService.getAll();

        // Assert
        Assertions.assertEquals(1, results.size());
    }
}