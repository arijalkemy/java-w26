package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Struct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentTest(){

        StudentDTO stu = loadStudent();


        studentController.registerStudent(stu);


        verify(studentService,times(1)).create(stu);

    }

    @Test
    void getStudentByIdTest(){
        StudentDTO stu = loadStudent();

        when(studentService.read(stu.getId())).thenReturn(stu);


        Assertions.assertEquals(stu,studentController.getStudent(stu.getId()));

        verify(studentService,times(1)).read(stu.getId());
    }

    @Test
    void updateStudentTest(){

        StudentDTO stu = loadStudent();


        studentController.modifyStudent(stu);


        verify(studentService,times(1)).update(stu);

    }

    @Test
    void deleteStudentTest(){

        StudentDTO stu = loadStudent();


        studentController.removeStudent(stu.getId());


        verify(studentService,times(1)).delete(stu.getId());

    }

    @Test
    void listStudentsTest(){
        StudentDTO stu = loadStudent();

        Set<StudentDTO> setStudents = new HashSet();

        setStudents.add(stu);

        when(studentService.getAll()).thenReturn(setStudents);

        Set<StudentDTO> result = studentController.listStudents();

        Assertions.assertEquals(setStudents,result);

        verify(studentService,times(1)).getAll();

    }



    public StudentDTO loadStudent(){
        StudentDTO stu = new StudentDTO();
        stu.setId((long) 1);
        stu.setSubjects(Arrays.asList(new SubjectDTO("Matematica", 8.0), new SubjectDTO("Lengua", 10.0)));
        stu.setStudentName("Pedro");
        return stu;
    }

}
