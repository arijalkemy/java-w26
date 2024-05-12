package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    public void notExists() {
        StudentDTO student = new StudentDTO();
        student.setId(101L);
        student.setStudentName("John Doe");
        student.setAverageScore(8.5);
        student.setMessage("Good student");
        student.setSubjects(new ArrayList<>());

        assertFalse(studentDAO.exists(student));
    }

    @Test
    public void save() {
        StudentDTO student = new StudentDTO();
        student.setId(null);
        student.setStudentName("John Doe");
        student.setAverageScore(8.5);
        student.setMessage("Good student");
        student.setSubjects(new ArrayList<>());

        // El método "save" cambia el valor del id
        studentDAO.save(student);

        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void findById() {
        StudentDTO student = new StudentDTO();
        student.setId(null);
        student.setStudentName("John Doe");
        student.setAverageScore(8.5);
        student.setMessage("Good student");
        student.setSubjects(new ArrayList<>());

        studentDAO.save(student);

        Long newId = student.getId();
        StudentDTO foundStudent = studentDAO.findById(newId);

        assertNotNull(foundStudent);
        assertEquals(student.getId(), foundStudent.getId());
    }


    @Test
    public void update() {
        StudentDTO student = new StudentDTO();
        student.setId(null);
        student.setStudentName("John Doe");
        student.setAverageScore(8.5);
        student.setMessage("Good student");
        student.setSubjects(new ArrayList<>());

        studentDAO.save(student);

        Long newId = student.getId();
        StudentDTO updatedStudent = new StudentDTO();
        updatedStudent.setId(newId);
        updatedStudent.setStudentName("Jane Doe");
        updatedStudent.setAverageScore(9.0);
        updatedStudent.setMessage("Excellent student");
        updatedStudent.setSubjects(new ArrayList<>());

        studentDAO.save(updatedStudent);

        newId = student.getId();
        StudentDTO foundStudent = studentDAO.findById(newId);

        assertNotNull(foundStudent);
        assertEquals("Jane Doe", foundStudent.getStudentName());
        assertEquals(9.0, foundStudent.getAverageScore(), 0.01);
        assertEquals("Excellent student", foundStudent.getMessage());
    }


    @Test
    public void delete() {
        StudentDTO student = new StudentDTO();
        student.setId(null);
        student.setStudentName("John Doe");
        student.setAverageScore(8.5);
        student.setMessage("Good student");
        student.setSubjects(new ArrayList<>());

        studentDAO.save(student);

        assertTrue(studentDAO.exists(student));

        Long newId = student.getId();
        studentDAO.delete(newId);

        assertFalse(studentDAO.exists(student));
    }

}


