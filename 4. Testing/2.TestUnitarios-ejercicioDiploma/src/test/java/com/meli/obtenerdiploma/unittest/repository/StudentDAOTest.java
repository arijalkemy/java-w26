package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exceptions.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();


    @Test
    @DisplayName("Se agrega un nuevo estudiante")
    public void addStudentTest() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(9999L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));
        //ACT
        studentDAO.save(studentDTO);
    }

    @Test
    @DisplayName("Se agrega un estudiante existente")
    public void addExistStudentTest() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));

        //ACT
        studentDAO.save(studentDTO);

    }

    @Test
    @DisplayName("Se elimina un estudiante existente")
    public void deleteStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(9999L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));
        studentDAO.save(studentDTO);
        //ACT
        boolean bool = studentDAO.delete(studentDTO.getId());
        //ASSERT
        Assertions.assertTrue(bool);
    }

    @Test
    @DisplayName("Se elimina un estudiante no existente")
    public void deleteNonExistStudentTest() {
        //ACT
        boolean bool = studentDAO.delete(999L);
        //ASSERT
        Assertions.assertFalse(bool);
    }

    @Test
    @DisplayName("Se busca por id un estudiante existente")
    public void findById() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(999L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));
        //ACT
        studentDAO.save(studentDTO);
        StudentDTO studentDTOResponse = studentDAO.findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO, studentDTOResponse);
    }

    @Test
    @DisplayName("Se busca por id un estudiante no existente")
    public void findByIdNonExistStudentTest() {
        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(99999L));
    }

    @Test
    @DisplayName("Se actualiza  un estudiante existente")
    public void updateStudentTest() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(999L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));
        studentDAO.save(studentDTO);
        //ACT
        studentDTO.setStudentName("Pedro");
        studentDTO.setMessage("actualizacion");
        studentDAO.save(studentDTO);
        //ASSERT
        StudentDTO studentDTOResponse = studentDAO.findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO, studentDTOResponse);
    }

    @Test
    @DisplayName("se busca un usuario existente")
    public void ExistStudentTest() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(999L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));
        studentDAO.save(studentDTO);
        //ACT
        boolean response = studentDAO.exists(studentDTO);
        //ASSERT
        Assertions.assertTrue(response);
    }

    @Test
    @DisplayName("se busca un usuario inexistente")
    public void UnExistStudentTest() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(999L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("mensaje");
        studentDTO.setAverageScore(5.0);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(5.0);
        studentDTO.setSubjects(List.of(subjectDTO));
        //ACT
        boolean response = studentDAO.exists(studentDTO);
        //ASSERT
        Assertions.assertFalse(response);
    }

}
