package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    public void createStudentTest() {
        StudentDTO expected = new StudentDTO(3L, "Edwin", "student test", 9.00, List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("Spanish", 80.0)
        ));
        studentDAO.save(expected);

        StudentDTO actual = studentDAO.findById(expected.getId());
        // Assert
        Assertions.assertEquals(expected, actual);
        studentDAO.delete(3L);
    }
}
