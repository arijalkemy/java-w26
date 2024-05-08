package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentAllreadyExistException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentDAOUnitTest {
    static SubjectDTO subjectDTO;
    static StudentDTO studentDTO;
    static StudentDAO studentDAO;

    @BeforeAll
    static void setUp() {
        IStudentRepository studentRepository = new StudentRepository();
        studentDAO = new StudentDAO(studentRepository);
        subjectDTO = new SubjectDTO("Matematica", 10.0);
        studentDTO = new StudentDTO(1L, "Juan", "Perez", 6.0,
                new ArrayList<>(List.of(subjectDTO)));
        studentDAO.deleteAll();
    }


    @Test
    @Order(1)
    @DisplayName("Test save with non-existing  id = 1")
    void save_nonExistingId() {
        long id = studentDAO.save(studentDTO);
        assertEquals(studentDTO.getId(), id);
    }

    @Test
    @Order(2)
    @DisplayName("Test save with  existing id = 1")
    void save_existingId() {
        assertThrows(StudentAllreadyExistException.class, () -> studentDAO.save(studentDTO));
    }

    @Test
    @Order(3)
    @DisplayName("Test delete with existing id = 1")
    void delete_existingId() {
        boolean result = studentDAO.delete(1L);
        assertTrue(result);
    }

    @Test
    @Order(4)
    @DisplayName("Test delete with non-existing id = 1")
    void delete_nonExistingId() {
        boolean result = studentDAO.delete(1L);
        assertFalse(result);
    }


    @AfterAll
    static void tearDown() {
        studentDAO.deleteAll();
    }

}