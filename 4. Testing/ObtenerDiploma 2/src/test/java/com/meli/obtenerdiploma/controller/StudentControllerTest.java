package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void getStudentTest(){
        long idStudent = 1;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        Mockito.when(studentService.read(idStudent)).thenReturn(studentDTO);

        StudentDTO result = studentController.getStudent(idStudent);

        Assertions.assertEquals(result.getId(),studentDTO.getId());
        Assertions.assertEquals(result.getClass(), StudentDTO.class);

    }

}
