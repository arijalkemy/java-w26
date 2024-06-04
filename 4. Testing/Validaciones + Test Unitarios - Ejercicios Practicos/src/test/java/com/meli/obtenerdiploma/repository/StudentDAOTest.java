package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {
    StudentDAO studentDAO;
    StudentDTO newStudent;

    @BeforeEach
    public void setup() {
        studentDAO = new StudentDAO();

        newStudent = new StudentDTO();
        newStudent.setStudentName("Juan");
        newStudent.setSubjects(
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Lengua", 8.0),
                        new SubjectDTO("Historia", 9.0)
                )
        );

        if(studentDAO.exists(newStudent)) {
            studentDAO.delete(newStudent.getId());
        }
    }

    @AfterEach
    public void tearDown() {
        newStudent.setId(7L);

        if(studentDAO.exists(newStudent)) {
            studentDAO.delete(newStudent.getId());
        }
    }

    @Test
    public void saveTest() {
        // Act
        studentDAO.save(newStudent);

        // Assert
        StudentDTO savedStudent = studentDAO.findById(newStudent.getId());
        Assertions.assertEquals(newStudent, savedStudent);
    }

    @Test
    public void deleteTest() {
        studentDAO.save(newStudent);
        studentDAO.delete(newStudent.getId());

        boolean exists = studentDAO.exists(newStudent);

        Assertions.assertFalse(exists);
    }

    @Test
    public void existTest() {
        studentDAO.save(newStudent);
        Assertions.assertTrue(studentDAO.exists(newStudent));
    }

    @Test
    public void findByIdTest() {
        studentDAO.save(newStudent);
        StudentDTO foundStudent = studentDAO.findById(newStudent.getId());

        Assertions.assertEquals(newStudent, foundStudent);
    }

    @Test
    public void userNotFoundTest() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100L));
    }
}
