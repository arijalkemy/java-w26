package com.meli.obtenerdiploma.unit.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.StudentBuilder;


import org.springframework.http.HttpStatus;

@SpringBootTest
public class StudentControllerTest {
    @MockBean
    private IStudentService studentServiceMock;

    @Autowired
    private StudentController systemUnderTest;

    @Test
    @DisplayName("Test for register a Student using Controller")
    public void registerStudentTest() {

        //Arrange
        StudentDTO studentToRegister = StudentBuilder.getStudentDTOGoodAverage();

        //Act
        ResponseEntity<?> result = systemUnderTest.registerStudent(studentToRegister);

        //Assertions
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(result.getBody(), null);
    }

    @Test
    @DisplayName("Test for getAll Students")
    public void getAllStudentsTest() {
        //Arrange

        //Act
        when(studentServiceMock.getAll()).thenReturn(StudentBuilder.studentsFromJSON());
        Set<StudentDTO> listStudentsResult = systemUnderTest.listStudents();
        
        //Assertions

        Assertions.assertEquals(2, listStudentsResult.size());
    }

    @Test
    @DisplayName("Test for modify Student")
    public void modifyStudentTest() {
        //Arrange
        StudentDTO studentDTO = StudentBuilder.getStudentTest();
        
        //Act
        ResponseEntity<?> result =  systemUnderTest.modifyStudent(studentDTO);
        
        //Assertions
        verify(studentServiceMock, times(1)).update(studentDTO); 
    }

    @Test
    @DisplayName("Test get student")
    public void getStudentTest()
    {
        //Arrange
        Long idStudent = 1L;
        
        //Act
        StudentDTO studentDTOResult =  this.systemUnderTest.getStudent(idStudent);

        //Assertions
        verify(studentServiceMock).read(idStudent);
    }

    @Test
    @DisplayName("Test for delete a student")
    public void removeStudentTest()
    {
        //Arrange
        Long idStudent = 1L;
        
        //Act
        ResponseEntity<?> studentDTOResult =  this.systemUnderTest.removeStudent(idStudent);

        //Assertions
        verify(studentServiceMock).delete(idStudent);

    }
}
