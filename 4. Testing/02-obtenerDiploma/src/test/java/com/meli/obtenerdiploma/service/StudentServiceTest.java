package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentRepository studentRepository;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(1L, "Camila", List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Física", 4.0)
        ));

    }

    @Test
    void create() {
        studentService.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void read() {
        studentService.read(studentDTO.getId());
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals(studentDTO, studentService.read(studentDTO.getId()));
    }

    @Test
    void update() {
        studentService.update(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void delete() {
        studentService.delete(studentDTO.getId());
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void getAll() {
        Set<StudentDTO> studentsExpected = new HashSet<>();
        studentsExpected.add(studentDTO);
        when(studentRepository.findAll()).thenReturn(studentsExpected);

        Set<StudentDTO> studentsActual = studentService.getAll();

        assertEquals(studentsExpected, studentsActual);
    }
}