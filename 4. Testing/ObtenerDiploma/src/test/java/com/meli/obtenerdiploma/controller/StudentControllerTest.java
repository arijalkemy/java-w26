package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private StudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    @DisplayName("Enpoint get student by id: successful")
    public void getStudentByIdSuccessfulTest() {
        // Arrange
        StudentDTO expected = new StudentDTO(1L, "Edwin", "student test", 9.00, List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("Spanish", 80.0)
        ));
        when(service.read(1L)).thenReturn(expected);
        // Act
        StudentDTO actual = controller.getStudent(1L);
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Enpoint get student by id: null")
    public void getStudentByIdNullTest() {
        //Arrange
        when(service.read(1L)).thenThrow(new StudentNotFoundException(1L));
        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> controller.getStudent(1L));
    }

    @Test
    @DisplayName("Enpoint get all students")
    public void getAllStudent() {
        // Arrange
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(
                new StudentDTO(1L, "Juan", null, null, List.of(
                        new SubjectDTO("Matemática", 9D),
                        new SubjectDTO("Física", 7D),
                        new SubjectDTO("Química", 6D)
                ))
        );
        expected.add(
                new StudentDTO(2L, "Pedro", null, null, List.of(
                        new SubjectDTO("Matemática", 10D),
                        new SubjectDTO("Física", 8D),
                        new SubjectDTO("Química", 4D)
                ))
        );
        when(service.getAll()).thenReturn(expected);
        // Act
        Set<StudentDTO> actual = controller.listStudents();

        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
