package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.CompareSets;
import com.meli.obtenerdiploma.util.InitialDataTest;
import com.meli.obtenerdiploma.util.StudentUseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @DisplayName("Registar un nuevo estudiante")
    @Test
    public void registerStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentTest();

        //Act
        studentController.registerStudent(studentDTO);

        //Asset
        Mockito.verify(studentService, Mockito.atLeastOnce()).create(studentDTO);
    }

    @DisplayName("Obtener estudiante")
    @Test
    public void getStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageTen();
        StudentDTO response;
        Mockito.when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        response= studentController.getStudent(studentDTO.getId());


        //Asset
        Mockito.verify(studentService, Mockito.atLeastOnce()).read(studentDTO.getId());
        Assertions.assertEquals(studentDTO, response);
    }

    @DisplayName("Actualizar estudiante")
    @Test
    public void updateStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageTen();

        //Act
        studentController.modifyStudent(studentDTO);

        //Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).update(studentDTO);
    }

    @DisplayName("Eliminar estudiante")
    @Test
    public void deleteStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageTen();

        //Act
        studentController.removeStudent(studentDTO.getId());

        //Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).delete(studentDTO.getId());
    }

    @DisplayName("Listar Estudiantes")
    @Test
    public void getAllStudents() {
        //Arrange
        Set<StudentDTO> listaEstudiantes = InitialDataTest.STUDENTS;
        Set<StudentDTO> response;
        Mockito.when(studentService.getAll()).thenReturn(listaEstudiantes);

        //Act
        response = studentController.listStudents();

        //Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).getAll();
        Assertions.assertTrue(CompareSets.compare(listaEstudiantes, response));
    }
}
