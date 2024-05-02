package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Ejercicio5 {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO student;

    @BeforeEach
    void setUp(){
        student = new StudentDTO();
        student.setId(1L);
    }

    @Test
    @DisplayName("Registrar usuario")
    void registerStudent(){
        ResponseEntity<?> response = studentController.registerStudent(student);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(studentService, times(1)).create(student);
    }

    @Test
    @DisplayName("Obtener estudiante por id")
    void getStudentById(){
        when(studentService.read(student.getId())).thenReturn(student);

        StudentDTO actualStudent = studentController.getStudent(student.getId());

        assertEquals(student, actualStudent);
        verify(studentService, times(1)).read(student.getId());
    }

    @Test
    @DisplayName("Modificar estudiante")
    void modifyStudent(){
        ResponseEntity<?> response = studentController.modifyStudent(student);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(studentService, times(1)).update(student);
    }

    @Test
    @DisplayName("Eliminar estudiante")
    void deleteStudent(){
        ResponseEntity<?> response = studentController.removeStudent(student.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(studentService, times(1)).delete(student.getId());
    }

    @Test
    @DisplayName("Listar todos los estudiantes")
    void listStudents(){
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(student);

        when(studentService.getAll()).thenReturn(expectedStudents);

        Set<StudentDTO> actualStudents = studentController.listStudents();

        assertEquals(expectedStudents, actualStudents);
        verify(studentService, times(1)).getAll();
    }
}
