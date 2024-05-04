package com.meli.obtenerdiploma.units.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtils;
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
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Registra un estudiante y devuelve un ResponseEntity")
    public void registerStudentTest() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTO();

        //Acto
        ResponseEntity<?> output = studentController.registerStudent(studentDTO);

        //Assert
        Assertions.assertEquals( ResponseEntity.ok(null),output);
        verify(studentService, atLeast(1)).create(studentDTO);
    }

    @Test
    @DisplayName("Busca un estudiante por id y devuelve un StudentDTO")
    public void getStudentByIdTest() {
        //Arrange
        StudentDTO expected = TestUtils.createStudentDTO();

        //Acto
        when(studentService.read(expected.getId())).thenReturn(expected);
        StudentDTO output = studentController.getStudent(expected.getId());

        //Assert
        Assertions.assertEquals(expected,output);
    }

    @Test
    @DisplayName("Modifica un estudiante")
    public void modifyStudentTest() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTO();

        //Acto
        ResponseEntity<?> output = studentController.modifyStudent(studentDTO);

        //Assert
        Assertions.assertEquals( ResponseEntity.ok(null),output);
        verify(studentService, atLeast(1)).update(studentDTO);
    }

    @Test
    @DisplayName("elimina un estudiante")
    public void deleteStudentTest() {
        //Arrange
        Long id = 1L;

        //Acto
        ResponseEntity<?> output = studentController.removeStudent(id);

        //Assert
        Assertions.assertEquals( ResponseEntity.ok(null),output);
        verify(studentService, atLeast(1)).delete(id);
    }

    @Test
    @DisplayName("devuelve un Set con todos los estudiantes")
    public void getSetOfStudentsTest() {
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(new StudentDTO(1L, "Pepito","Mensaje",10.0, List.of()));
        expected.add(new StudentDTO(2L, "Pepito 2","Mensaje",9.0, List.of()));
        expected.add(new StudentDTO(3L, "Pepito 3","Mensaje",8.0, List.of()));

        //Acto
        when(studentService.getAll()).thenReturn(expected);
        Set<StudentDTO> output = studentController.listStudents();

        //Assert
        Assertions.assertEquals(expected,output);
    }
}
