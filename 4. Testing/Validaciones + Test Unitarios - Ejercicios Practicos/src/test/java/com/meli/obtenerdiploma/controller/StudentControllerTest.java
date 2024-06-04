package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    StudentDTO student;

    @BeforeEach
    public void setUp() {
        Long studentId = 1L;
        student = new StudentDTO();
        student.setId(studentId);
        student.setStudentName("Juan");
        student.setSubjects(
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Lengua", 8.0),
                        new SubjectDTO("Historia", 9.0)
                )
        );

        student.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        student.setAverageScore(7.3);
    }

    @Test
    public void registerStudentTest() {
        ResponseEntity<?> response = controller.registerStudent(student);

        verify(service).create(student);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNull(response.getBody());
    }

    @Test
    public void getStudentByIdTest() {
        when(service.read(1L)).thenReturn(student);

        StudentDTO response = controller.getStudent(1L);

        verify(service).read(1L);

        Assertions.assertEquals(student, response);
    }

    @Test
    public void getStudentNotFountTest() {
        when(service.read(1L)).thenReturn(null);

        StudentDTO response = controller.getStudent(1L);

        verify(service).read(1L);

        Assertions.assertNull(response);
    }

    @Test
    public void modifyStudentTest() {
        ResponseEntity<?> response = controller.modifyStudent(student);

        verify(service).update(student);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNull(response.getBody());
    }

    @Test
    public void removeStudentTest() {
        ResponseEntity<?> response = controller.removeStudent(1L);

        verify(service).delete(1L);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNull(response.getBody());
    }

    @Test
    public void listStudentsTest() {
        Set<StudentDTO> students = Set.of(
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO()
        );

        when(service.getAll()).thenReturn(students);

        Set<StudentDTO> response = controller.listStudents();

        Assertions.assertEquals(3, response.size());
    }
}
