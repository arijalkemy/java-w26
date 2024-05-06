package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach
    private void setUp() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void testAddStudent() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "John Doe", "Message", 80.0,
                new ArrayList<>());

        // act
        studentDAO.save(student);

        // assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void testFindStudentById_ExistingStudent() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "John Doe", "Message", 80.0,
                new ArrayList<>());
        studentDAO.save(student);

        // act
        StudentDTO foundStudent = studentDAO.findById(1L);

        // assert
        assertNotNull(foundStudent);
        assertEquals(student, foundStudent);
    }

    @Test
    public void testFindStudentById_NonExistingStudent() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100L));
    }

    @Test
    public void testUpdateStudent() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "John Doe", "Message", 80.0,
                new ArrayList<>());
        studentDAO.save(student);

        // act
        student.setMessage("New message");
        student.setAverageScore(90.0);
        studentDAO.save(student);

        // assert
        assertEquals("New message", studentDAO.findById(1L).getMessage());
        assertEquals(90.0, studentDAO.findById(1L).getAverageScore());
    }

    @Test
    public void testDeleteStudent_ExistingStudent() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "John Doe", "Message",
                80.0, new ArrayList<>());
        studentDAO.save(student);

        // act
        studentDAO.delete(1L);

        // assert
        assertFalse(studentDAO.exists(student));
    }

    @Test
    public void testDeleteStudent_NonExistingStudent() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "John Doe", "Message",
                80.0, new ArrayList<>());

        assertDoesNotThrow(() -> studentDAO.delete(100L));
    }


}
