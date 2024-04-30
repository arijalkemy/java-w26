package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
class StudentDAOUnitTest {
    SubjectDTO subjectDTO;
    StudentDTO studentDTO;
    StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
        subjectDTO = new SubjectDTO("Matematica", 10.0);
        studentDTO = new StudentDTO(99L,
                "Juan",
                "Perez",
                6.0,
                new ArrayList<>(List.of(subjectDTO)));
    }

    @AfterEach
    void tearDown() {
        studentDAO.delete(99L);


        studentDTO.setId(1L);
        studentDAO.save(studentDTO);
    }


    @Test
    @DisplayName("Test save with non-existing or existing id")
    void save_nonExistingId() {
        studentDTO.setId(99L);

        long id = studentDAO.save(studentDTO);
        assertEquals(studentDTO.getId(), id);
    }

    @Test
    @DisplayName("Test delete with existing id")
    void delete_existingId() {
        studentDAO.save(studentDTO);
        boolean result = studentDAO.delete(1L);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Test delete with non-existing id")
    void delete_nonExistingId() {
        boolean result = studentDAO.delete(99L);
        assertEquals(false, result);
    }

}