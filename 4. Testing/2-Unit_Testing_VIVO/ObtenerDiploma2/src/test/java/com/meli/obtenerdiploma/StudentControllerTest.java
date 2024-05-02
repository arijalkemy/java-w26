package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Registrando estudiante")
    public void registerStudentTest(){
        SubjectDTO subjectOne = new SubjectDTO("Artes",8.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",9.0);
        StudentDTO studentDTO = new StudentDTO(1L,"Tommy","",0.0, List.of(subjectOne,subjectTwo));

        studentController.registerStudent(studentDTO);

        verify(studentService,atLeastOnce()).create(studentDTO);
    }
    @Test
    @DisplayName("Obteniendo estudiante")
    public void getStudentTest(){
        SubjectDTO subjectOne = new SubjectDTO("Musica",2.0);
        SubjectDTO subjectTwo = new SubjectDTO("Informatica",7.0);
        StudentDTO studentDTO = new StudentDTO(4L,"Julia","",0.0, List.of(subjectOne,subjectTwo));

        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO expectedStudent = studentController.getStudent(studentDTO.getId());

        verify(studentService,atLeastOnce()).read(studentDTO.getId());
        Assertions.assertEquals(expectedStudent,studentDTO);
    }
    @Test
    @DisplayName("Modificando estudiante")
    public void updateStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Musica",10.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",10.0);
        StudentDTO studentDTO = new StudentDTO(7L,"Abel","",0.0, List.of(subjectOne,subjectTwo));

        studentController.modifyStudent(studentDTO);

        verify(studentService,atLeastOnce()).update(studentDTO);
    }
    @Test
    @DisplayName("Borrando estudianet")
    public void deleteStudentTest(){
        SubjectDTO subjectOne = new SubjectDTO("Artes",8.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",9.0);
        StudentDTO studentDTO = new StudentDTO(9L,"Tommy","",0.0, List.of(subjectOne,subjectTwo));

        studentController.removeStudent(studentDTO.getId());

        verify(studentService,atLeastOnce()).delete(studentDTO.getId());
    }

}
