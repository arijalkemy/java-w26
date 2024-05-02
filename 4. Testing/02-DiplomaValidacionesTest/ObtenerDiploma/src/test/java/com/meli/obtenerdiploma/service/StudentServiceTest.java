package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import static com.meli.obtenerdiploma.util.UtilStudentGenerator.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentServiceTest {

    //creo mock de StudentDAO
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Read student")
    public void checkReadStudent(){
        //Arrange
        Long studentId = 1L;
        StudentDTO responseStudent = studentWithAbove9Average("Juan Perez", studentId);

        //act
        when(studentDAO.findById(studentId)).thenReturn(responseStudent);

        var obtained  = studentService.read(studentId);

        //assert
        Assertions.assertEquals(obtained, responseStudent);
    }

    @Test
    @DisplayName("Show all students")
    public void getAllStudentsTest(){
        //Arrange
        Long studentId1 = 1L;
        StudentDTO responseStudent1 = studentWithAbove9Average("Oliver Giroud", studentId1);

        Long studentId2 = 2L;
        StudentDTO responseStudent2 = studentWithBelow9Average("Roy Keane", studentId2);

        Set<StudentDTO> response =  new HashSet<>();
        response.add(responseStudent1);
        response.add(responseStudent2);


        //act
        when(studentRepository.findAll()).thenReturn(response);

        var obtained = studentService.getAll();

        //assert

        Assertions.assertEquals(obtained, response);
    }

    @Test
    @DisplayName("Delete Student Test")
    public void deleteStudentTest(){
        //arrange
        StudentDTO student = studentWithAbove9Average("Carlos Tevez", 1L);

        //act
        studentService.delete(student.getId());

        //assert
        verify(studentDAO, atLeastOnce()).delete(student.getId());
    }

}
