package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Verificar que se este llamando el metodo create y evaluar el http response code")
    public void registerStudentTest()
    {

        // Arrange

        StudentDTO student = new StudentDTO.Builder()
                .studentName("Jose")
                .build();

        // Act

        doNothing().when(studentService).create(any(StudentDTO.class));
        ResponseEntity<?> response = studentController.registerStudent(student);

        // Assertions

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        verify(studentService, times(1)).create(any(StudentDTO.class));

    }

    @Test
    @DisplayName("Verficar que el metodo read retorne el objeto con las caracteristicas correctas ademas del codigo de respuesta correcto")
    public void getStudent()
    {
        // Arrange

        StudentDTO studentExpected = new StudentDTO.Builder()
                .studentName("francisco")
                .setId(101L)
                .build();

        // Act

        when(studentService.read(anyLong())).thenReturn(studentExpected);
        StudentDTO studentResponse = studentController.getStudent(studentExpected.getId());

        // Assertions

        verify(studentService, times(1)).read(anyLong());
        Assertions.assertEquals(studentExpected, studentResponse);
    }

    @Test
    @DisplayName("Verificar que se este llamando el metodo update del service y evaluar el http response code")
    public void modifyStudentTest()
    {
        // Arrange

        StudentDTO student = new StudentDTO.Builder()
                .studentName("Jose")
                .build();

        // Act

        doNothing().when(studentService).update(any(StudentDTO.class));
        ResponseEntity<?> response = studentController.modifyStudent(student);

        // Assertions

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        verify(studentService, times(1)).update(any(StudentDTO.class));
    }

    @Test
    @DisplayName("Revisar que el metodo delete del service sea llamado y verificar el status code")
    public void removeStudentTest()
    {
        // Arrange

        long idToRemove = 101L;

        // Act

        doNothing().when(studentService).delete(anyLong());
        ResponseEntity<?> response = studentController.removeStudent(idToRemove);

        // Assertions

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        verify(studentService, times(1)).delete(anyLong());
    }

    @Test
    @DisplayName("Verificar que el metoodo getAll del service sea llamado correctamente y que la respuesta sea efectivamente un set")
    public void listStudentsTest()
    {
        StudentDTO student1= new StudentDTO.Builder()
                .studentName("jose")
                .build();
        StudentDTO student2 = new StudentDTO.Builder()
                .studentName("ricardo")
                .build();

        Set<StudentDTO> studentsExpected = new HashSet<>(List.of(student1, student2));


        // Act

        when(studentService.getAll()).thenReturn(studentsExpected);
        Set<StudentDTO> studentsResponse = studentController.listStudents();

        // Asssertions

        Assertions.assertEquals(studentsExpected, studentsResponse);
    }
}
