package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Se crea un estudiante")
    public void registerStudentTest() {
        StudentDTO studentMock = new StudentDTO();
        studentMock.setId(9999L);
        studentMock.setStudentName("Juan");
        studentMock.setMessage("mensaje");
        studentMock.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentMock.setSubjects(List.of(subjectDTO));

        ResponseEntity<?> response = studentController.registerStudent(studentMock);
        verify(studentService, atLeast(1)).create(studentMock);
        Assertions.assertEquals(ResponseEntity.ok(null), response);
    }

    @Test
    @DisplayName("se busca el estudiante creado")
    public void getStudentTest() {
        StudentDTO studentMock = new StudentDTO();
        studentMock.setId(1L);
        studentMock.setStudentName("Juan");
        studentMock.setMessage("mensaje");
        studentMock.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentMock.setSubjects(List.of(subjectDTO));

        Long idStudent = studentMock.getId();

        when(studentService.read(idStudent)).thenReturn(studentMock);
        StudentDTO response = studentController.getStudent(idStudent);
        Assertions.assertEquals(studentMock, response);

    }

    @Test
    @DisplayName("se modifica el estudiante creado")
    public void modifyStudent() {
        StudentDTO studentMock = new StudentDTO();
        studentMock.setId(1L);
        studentMock.setStudentName("Juan");
        studentMock.setMessage("mensaje");
        studentMock.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentMock.setSubjects(List.of(subjectDTO));

        ResponseEntity<?> response = studentController.modifyStudent(studentMock);
        verify(studentService, atLeast(1)).update(studentMock);
        Assertions.assertEquals(ResponseEntity.ok(null), response);
    }

    @Test
    @DisplayName("se eleimina un estudiante existente")
    public void deleteStudentTest() {
        Long idStudent = 1L;

        ResponseEntity<?> response = studentController.removeStudent(idStudent);
        verify(studentService, atLeast(1)).delete(idStudent);
        Assertions.assertEquals(ResponseEntity.ok(null), response);
    }

    @Test
    @DisplayName("se obtiene la lista de estudiantes existente")
    public void getAllStudentsTest() {
        StudentDTO studentMock = new StudentDTO();
        studentMock.setId(1L);
        studentMock.setStudentName("Juan");
        studentMock.setMessage("mensaje");
        studentMock.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentMock.setSubjects(List.of(subjectDTO));
        Set<StudentDTO> listOfStudents = new HashSet<>();
        listOfStudents.add(studentMock);
        when(studentService.getAll()).thenReturn(listOfStudents);

        Set<StudentDTO> response = studentController.listStudents();
        Assertions.assertEquals(listOfStudents, response);
    }
}
