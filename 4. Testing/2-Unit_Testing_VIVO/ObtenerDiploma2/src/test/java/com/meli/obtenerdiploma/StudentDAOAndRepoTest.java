package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOAndRepoTest {

    StudentDAO studentDAO = new StudentDAO();
    @Test
    @DisplayName("Guardando alumno exitosamente")
    public void addStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Artes",8.0);
        SubjectDTO subjectTwo = new SubjectDTO("Lengua",9.0);
        StudentDTO studentDTO = new StudentDTO(1L,"Jim","",0.0, List.of(subjectOne,subjectTwo));

        studentDAO.save(studentDTO);

        Assertions.assertTrue(studentDAO.exists(studentDTO));
        Assertions.assertEquals(studentDAO.findById(studentDTO.getId()),studentDTO);


    }
    @Test
    @DisplayName("Buscando alumno que existe")
    public void findExistingStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Musica",9.6);
        SubjectDTO subjectTwo = new SubjectDTO("Biologia",7.0);
        StudentDTO studentDTO = new StudentDTO(10L,"Chepe","",0.0,List.of(subjectOne,subjectTwo));

        studentDAO.save(studentDTO);

        Boolean isExistingStudent = studentDAO.exists(studentDTO);

        Assertions.assertTrue(isExistingStudent);
    }
    @Test
    @DisplayName("Buscando alumno que no existe")
    public void findingNonExistantStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Musica",9.6);
        SubjectDTO subjectTwo = new SubjectDTO("Biologia",7.0);
        StudentDTO studentDTO = new StudentDTO(100L,"Chepe","",0.0,List.of(subjectOne,subjectTwo));

        Boolean isExistingStudent = studentDAO.exists(studentDTO);

        Assertions.assertFalse(isExistingStudent);
    }
    @Test
    @DisplayName("Datos de estudiante modificados")
    public void modifyStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Musica",9.6);
        SubjectDTO subjectTwo = new SubjectDTO("Informatica",5.0);
        StudentDTO studentDTO = new StudentDTO(0L,"Abel","",0.0,List.of(subjectOne,subjectTwo));

        studentDTO.setStudentName("Modified");
        studentDTO.setId(5L);
        studentDTO.setMessage("Soy un estudiante con datos modificados");

        Assertions.assertEquals(studentDTO.getStudentName(),"Modified");
        Assertions.assertEquals(studentDTO.getId(),5L);
        Assertions.assertEquals(studentDTO.getMessage(),"Soy un estudiante con datos modificados");
    }
    @Test
    @DisplayName("Borrado de estudiante existente")
    public void deleteExistingStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Taller",8.6);
        SubjectDTO subjectTwo = new SubjectDTO("Ingles",9.0);
        StudentDTO studentDTO = new StudentDTO(0L,"Michael","",0.0,List.of(subjectOne,subjectTwo));


        studentDAO.save(studentDTO);
        boolean expected = studentDAO.delete(studentDTO.getId());

        Assertions.assertTrue(expected);
    }
    @Test
    @DisplayName("Borrado de estudiante no existente")
    public void deleteNotExistingStudent(){
        SubjectDTO subjectOne = new SubjectDTO("Taller",8.6);
        SubjectDTO subjectTwo = new SubjectDTO("Ingles",9.0);
        StudentDTO studentDTO = new StudentDTO(0L,"Michael","",0.0,List.of(subjectOne,subjectTwo));


        boolean expected = studentDAO.delete(studentDTO.getId());

        Assertions.assertFalse(expected);
    }
}
