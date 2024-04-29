package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach
    public void setup() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Guardar un estudiante con 2 materias aprobadas")
    public void saveStudent() {
        List<SubjectDTO> subjectDTO = List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("History", 8.0));
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "Hola", 9.0, subjectDTO);
        studentDAO.save(studentDTO);
        Assertions.assertTrue(studentDAO.exists(studentDTO));
        //Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.exists(null),
        //        "Expected studentDAO.exists() to throw StudentNotFoundException but it didn't. ");
    }

    @Test
    @DisplayName("Buscar un estudiante por ID")
    public void findStudentByID() {
        List<SubjectDTO> subjectDTO = List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("History", 8.0));
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "Hola", 9.0, subjectDTO);
        studentDAO.save(studentDTO);
        Assertions.assertEquals(studentDTO, studentDAO.findById(1L));
    }

    public void modifyStudent() {

    }

}
