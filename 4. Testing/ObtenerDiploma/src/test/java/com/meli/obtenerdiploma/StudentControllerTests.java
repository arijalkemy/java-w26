package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class StudentControllerTests {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;


    StudentDTO studentDTOUno = new StudentDTO();
    StudentDTO studentDTODos = new StudentDTO();

    Set<StudentDTO> studentDTOList = new HashSet<>();

    @BeforeEach
    void setUp() {
        studentDTOUno.setStudentName("Juan");
        studentDTOUno.setId(0L);

        studentDTODos.setStudentName("Pedro");
        studentDTODos.setId(1L);

        studentDTOList.add(studentDTOUno);
        studentDTOList.add(studentDTODos);
    }

    @Test
    @DisplayName("Se ejecuta el endpoint getStudent correctamente")
    public void testGetStudentById(){
        //Arrange
        when(studentController.getStudent(0L)).thenReturn(studentDTOUno);

        //Act
        StudentDTO studentDTO = studentController.getStudent(0L);

        //Assert
        Assertions.assertEquals("Juan", studentDTO.getStudentName());
    }

    @Test
    @DisplayName("Se ejecuta el endpoint listStudents correctamente")
    public void testListStudents(){
        //Arrange
        when(studentController.listStudents()).thenReturn(studentDTOList);

        //Act
        Set<StudentDTO> expectect = studentController.listStudents();

        //Assert
        Assertions.assertEquals(expectect, studentDTOList);
    }

}
