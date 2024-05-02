package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    StudentDTO studentJuanPerez;
    StudentDTO studentPedroLopez;

    @BeforeEach
    public void setup() {
        studentJuanPerez = new StudentDTO(
                1L,
                "Juan Perez",
                "",
                0.0,
                List.of(new SubjectDTO("Matematica", 9.0))
        );
        studentPedroLopez = new StudentDTO(
                2L,
                "Pedro Lopez",
                "",
                0.0,
                List.of(new SubjectDTO("Matematica", 8.0))
        );

        studentDAO.save(studentPedroLopez);
    }

    @Test
    @DisplayName("Se crea al alumno Juan Perez correctamente")
    public void createSuccessfully() {
        studentService.create(studentJuanPerez);
        verify(studentDAO, atLeast(1)).save(studentJuanPerez);
    }

    @Test
    @DisplayName("Se busca al alumno con id = 1L y se encuentra")
    public void readSuccessfully() {
        when(studentDAO.findById(1L)).thenReturn(studentJuanPerez);
        StudentDTO resultStudentDTO = studentService.read(1L);
        assertEquals(resultStudentDTO, studentJuanPerez);
    }

    @Test
    @DisplayName("Se busca al alumno con id = 1L y NO se encuentra")
    public void readThrowsStudentNotFoundException() {
        when(studentDAO.findById(1L)).thenThrow(StudentNotFoundException.class);
        assertThrows(
                StudentNotFoundException.class,
                () -> studentService.read(1L)
        );
    }

    @Test
    @DisplayName("Se actualiza al alumno Pedro Lopez a Pedro Perez correctamente")
    public void updateSuccessfully() {
        studentPedroLopez.setStudentName("Pedro Perez");
        studentService.update(studentPedroLopez);
        verify(studentDAO, atLeast(1)).save(studentPedroLopez);
    }

    @Test
    @DisplayName("Se borra al alumno Pedro Lopez correctamente")
    public void deleteSuccessfully() {
        when(studentDAO.delete(studentPedroLopez.getId())).thenReturn(true);
        studentService.delete(studentPedroLopez.getId());
        verify(studentDAO, atLeast(1)).delete(studentPedroLopez.getId());
    }

    @Test
    @DisplayName("Se intenta borrar al alumno Juan Perez y no se encuentra")
    public void deleteStudentNotFound() {
        when(studentDAO.delete(studentJuanPerez.getId())).thenReturn(false);
        studentService.delete(studentJuanPerez.getId());
        verify(studentDAO, atLeast(1)).delete(studentJuanPerez.getId());
    }

    @Test
    @DisplayName("Se buscan los alumnos y se devuelven todos")
    public void getAllSuccessfully() {
        Set<StudentDTO> expectedList = Set.of(studentPedroLopez, studentJuanPerez);
        when(studentRepository.findAll()).thenReturn(expectedList);
        Set<StudentDTO> studentDTOSList = studentService.getAll();
        assertEquals(studentDTOSList, expectedList);
    }

    @Test
    @DisplayName("Se buscan los alumnos y se devuelve vacio")
    public void getAllEmptyResult() {
        Set<StudentDTO> expectedResult = Set.of();
        when(studentRepository.findAll()).thenReturn(expectedResult);
        Set<StudentDTO> studentDTOSList = studentService.getAll();
        assertEquals(studentDTOSList, expectedResult);
    }
}
