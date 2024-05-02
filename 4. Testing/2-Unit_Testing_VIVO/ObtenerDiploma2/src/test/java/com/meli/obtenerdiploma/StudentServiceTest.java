package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Crear studiante")
    public void createStudentService(){
        SubjectDTO subjectOne = new SubjectDTO("Artes",8.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",9.0);
        StudentDTO studentDTO = new StudentDTO(9L,"Tommy","",0.0, List.of(subjectOne,subjectTwo));

        studentService.create(studentDTO);

        verify(studentDAO,atLeastOnce()).save(studentDTO);
    }
    @Test
    @DisplayName("Leer estudiante")
    public void readStudentService(){
        SubjectDTO subjectOne = new SubjectDTO("Artes",8.0);
        SubjectDTO subjectTwo = new SubjectDTO("Mecanica",10.0);
        StudentDTO studentDTO = new StudentDTO(33L,"Fernando","",0.0, List.of(subjectOne,subjectTwo));

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO expectedStudent = studentService.read(studentDTO.getId());

        verify(studentDAO,atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(expectedStudent,studentDTO);
    }
    @Test
    @DisplayName("Actualizar estudiante")
    public void updateStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Artes",10.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",10.0);
        StudentDTO studentDTO = new StudentDTO(9L,"Tommy Modificado","modificado",0.0, List.of(subjectOne,subjectTwo));

        studentService.update(studentDTO);

        verify(studentDAO,atLeastOnce()).save(studentDTO);
    }
    @Test
    @DisplayName("Borrar estudiante")
    public void deleteStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Informatica",7.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",5.0);
        StudentDTO studentDTO = new StudentDTO(1L,"Abel","",0.0, List.of(subjectOne,subjectTwo));

        when(studentDAO.delete(studentDTO.getId())).thenReturn(true);

        boolean value = studentDAO.delete(studentDTO.getId());

        verify(studentDAO,atLeastOnce()).delete(studentDTO.getId());
        Assertions.assertTrue(value);
    }
    @Test
    @DisplayName("Borrar estudiante no existente")
    public void deleteNonExistingStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Religion",10.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",5.0);
        StudentDTO studentDTO = new StudentDTO(666L,"Virunias","",0.0, List.of(subjectOne,subjectTwo));

        boolean value = studentDAO.delete(studentDTO.getId());

        verify(studentDAO,atLeastOnce()).delete(studentDTO.getId());
        Assertions.assertFalse(value);

    }

}
