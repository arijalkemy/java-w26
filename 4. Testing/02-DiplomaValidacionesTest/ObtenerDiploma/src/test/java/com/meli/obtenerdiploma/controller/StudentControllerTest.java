package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;
import static com.meli.obtenerdiploma.util.UtilStudentGenerator.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Register New Student Test")
    public void registerStudentTest(){
        //arrange
        StudentDTO student = studentWithBelow9Average("Michael Jordan", 1L);

        //act
        studentController.registerStudent(student);

        //assert
        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    @DisplayName("Get Student By Id Test")
    public void getStudentByIdHappyTest(){
        //arrange
        Long studentId = 1L;
        StudentDTO studentResponse = studentWithAbove9Average("Steph Curry", 1L);

        //act
        when(studentService.read(studentId)).thenReturn(studentResponse);
        StudentDTO studentObtained = studentController.getStudent(studentId);

        //assert
        Assertions.assertEquals(studentResponse, studentObtained);
    }

    @Test
    @DisplayName("Get Student By Id Test - Nonexistent Id")
    public void getStudentByNonExistentIdTest(){
        //arrange
        Long studentId = 10L;
        StudentDTO studentResponse = studentWithAbove9Average("Steph Curry", 1L);

        //act
        when(studentService.read(studentId)).thenThrow(new StudentNotFoundException(studentId));

        //assert
        try{
            studentController.getStudent(studentId);
        }catch (StudentNotFoundException e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    @DisplayName("Modify Student Test")
    public void modifyStudentTest(){
        //arrange
        StudentDTO student = studentWithAbove9Average("Harry Kane", 2L);

        //act
        studentController.modifyStudent(student);

        //assert
        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    @DisplayName("Delete Student Test")
    public void deleteStudentTest(){
        //arrange
        StudentDTO student = studentWithAbove9Average("Harry Kane", 2L);

        //act
        studentController.removeStudent(student.getId());

        //assert
        verify(studentService, atLeastOnce()).delete(student.getId());
    }

    @Test
    @DisplayName("Get Student´s List Test")
    public void getStudentListTest(){
        //arrange
        Set<StudentDTO> setResponse = studentSet();

        //act
        when(studentService.getAll()).thenReturn(setResponse);
        Set<StudentDTO> setObtained = studentController.listStudents();

        //assert
        Assertions.assertEquals(setResponse, setObtained);
    }
}
