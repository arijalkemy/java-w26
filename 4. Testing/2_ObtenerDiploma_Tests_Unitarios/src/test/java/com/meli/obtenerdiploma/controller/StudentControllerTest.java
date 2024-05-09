package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * Ver comentario en {@link com.meli.obtenerdiploma.service.StudentServiceTest}.
 */
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;


    @Test
    public void registerStudentOk() {

        StudentDTO student = StudentUtils.createCommonStudent(null);

        ResponseEntity<?> response = studentController.registerStudent(student);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isFalse();
    }

    @Test
    public void getStudentOk() {

        long studentId = 1;
        StudentDTO student = StudentUtils.createCommonStudent(studentId);

        when(studentService.read(studentId)).thenReturn(student);

        StudentDTO response = studentController.getStudent(studentId);

        assertThat(response).isEqualTo(student);
    }

    @Test
    public void modifyStudentOk() {

        StudentDTO student = StudentUtils.createCommonStudent(1L);

        ResponseEntity<?> response = studentController.modifyStudent(student);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isFalse();
    }

    @Test
    public void removeStudentOk() {

        ResponseEntity<?> response = studentController.removeStudent(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isFalse();
    }

    @Test
    public void listStudents() {

        Set<StudentDTO> students = StudentUtils.createTestStudents();

        when(studentService.getAll()).thenReturn(students);

        Set<StudentDTO> response = studentController.listStudents();

        assertThat(response).isEqualTo(students);
    }
}