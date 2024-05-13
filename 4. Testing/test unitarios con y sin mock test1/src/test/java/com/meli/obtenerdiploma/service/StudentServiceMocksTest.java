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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceMocksTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("crear estudiante")
    public void crearEstudiante() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("deded");

        studentDAO.save(studentDTO);

        studentService.create(studentDTO);

        verify(studentDAO, atLeast(1)).save(any());
    }

    @Test
    @DisplayName("buscar alumno por id")
    public void buscarAlumnoPorId() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("deded");
        studentDTO.setId(1L);

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO resposeStudente = studentService.read(studentDTO.getId());

        Assertions.assertEquals(studentDTO.getId(), resposeStudente.getId());

    }

    @Test
    @DisplayName("actualizacion de alumno")
    public void actualizacionAlumno() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("deded");
        studentDTO.setId(1L);

        studentDAO.save(studentDTO);

        studentService.update(studentDTO);

        verify(studentDAO, atLeast(1)).save(any());
    }

    @Test
    @DisplayName("eliminacion de estudiante")
    public void eliminacionEstudiante() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("deded");
        studentDTO.setId(1L);

        studentDAO.delete(studentDTO.getId());

        studentService.delete(studentDTO.getId());

        verify(studentDAO, atLeast(1)).delete(any());
    }

    @Test
    @DisplayName("todos los estudiantes")
    public void todosLosEstudiantes() {
        Set<StudentDTO> estudiantesSet = new HashSet<>();

        studentRepository.findAll();

        Set<StudentDTO> responseTodosLosEstudiantes = studentService.getAll();

        verify(studentRepository, atLeast(1)).findAll();
        Assertions.assertEquals(estudiantesSet, responseTodosLosEstudiantes);
    }
}
