package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() {
        StudentDTO student = new StudentDTO();
        studentController.registerStudent(student);

        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    public void getStudent() {
        // Crear el estudiante esperado
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(1L);
        expectedStudent.setStudentName("Juan");

        // Configurar el comportamiento del mock
        when(studentService.read(1L)).thenReturn(expectedStudent);

        // Llamar al método a probar
        StudentDTO actualStudent = studentController.getStudent(1L);

        // Verificar que el servicio fue llamado con el argumento correcto
        verify(studentService, atLeastOnce()).read(1L);

        // Verificar que el estudiante devuelto es el esperado
        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void modifyStudent() {
        StudentDTO student = new StudentDTO();
        studentController.modifyStudent(student);

        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    public void removeStudent() {
        studentController.removeStudent(1L);
        verify(studentService, atLeastOnce()).delete(1L);
    }

    @Test
    public void listStudents() {
        // Crear el conjunto de estudiantes esperado
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(new StudentDTO(1L, "Juan", null, null, null));
        expectedStudents.add(new StudentDTO(2L, "Maria", null, null, null));

        // Configurar el comportamiento del mock
        when(studentService.getAll()).thenReturn(expectedStudents);

        // Llamar al método a probar
        Set<StudentDTO> actualStudents = studentController.listStudents();

        // Verificar que el servicio fue llamado
        verify(studentService, atLeastOnce()).getAll();

        // Verificar que el conjunto de estudiantes devuelto es el esperado
        assertEquals(expectedStudents, actualStudents);
    }
}
