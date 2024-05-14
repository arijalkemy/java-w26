package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
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
    public void setUp() {

    }

    @Test
    public void createTest() {
        studentService.create(any());

        verify(studentDAO, atLeastOnce()).save(any());
    }

    @Test
    public void readTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        student.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        student.setAverageScore(7.3);

        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO studentDTO = studentService.read(1L);

        verify(studentDAO, atLeastOnce()).findById(anyLong());
        Assertions.assertEquals(student, studentDTO);
    }

    @Test
    public void updateTest() {
        studentService.update(any());

        verify(studentDAO, atLeastOnce()).save(any());
    }

    @Test
    public void deleteTest() {
        studentService.delete(1L);

        verify(studentDAO, atLeastOnce()).delete(anyLong());
    }

    @Test
    public void getAllTest() {
        // Act
        when(studentRepository.findAll()).thenReturn(Set.of(
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO()
        ));

        // Assert
        Set<StudentDTO> students = studentService.getAll();
        Assertions.assertEquals(6, students.size());
    }
}
