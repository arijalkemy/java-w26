package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    private IStudentDAO studentDAO;

    @BeforeEach
    public void setUpBeforeAll() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void testSaveStudent() {
        // Arrange
        StudentDTO studentDTO = TestUtilsGenerator.getNewStudent();

        // Act
        studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
        Assertions.assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }
}
