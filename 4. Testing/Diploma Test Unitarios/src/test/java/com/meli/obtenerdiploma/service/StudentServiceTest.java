package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @DisplayName("Crear un estudiante ")
    @Test
    public void createStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentTest();

        //Act
        studentDAO.save(studentDTO);

        //Assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).save(studentDTO);
    }

    @DisplayName("Buscar un estudiante por id")
    @Test
    public void searchStudentById() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageTen();

        //Act
        Mockito.when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        StudentDTO response = studentService.read(studentDTO.getId());

        //Assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO,response);
    }

    @DisplayName("Actualizar un estudiante")
    @Test
   public void updateStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageLessTen();
        studentDTO.setStudentName("Carlos Alberto");

        //Act
        studentService.update(studentDTO);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @DisplayName("Eliminar estudiante")
    @Test
    public void deleteStudent() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageLessTen();

        //Act
        studentService.delete(studentDTO.getId());

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(studentDTO.getId());

    }

    @DisplayName("Buscar todos los estudiantes")
    @Test
    public void searchStudents () {
        //Arrange
        Set<StudentDTO> studentDTOSet = InitialDataTest.STUDENTS;
        Set<StudentDTO> responseSet;
        //Act
        Mockito.when(studentRepository.findAll()).thenReturn(studentDTOSet);
        responseSet = studentService.getAll();

        //Assert
        Mockito.verify(studentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertTrue(CompareSets.compare(responseSet,studentDTOSet));

    }



}
