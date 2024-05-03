package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.StudentDtoBuilder;

class StudentDaoTest {

    static final Long id = Long.MAX_VALUE;
    static IStudentDAO studentDAO;

    @BeforeAll
    static void init() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Comprobar si existe un usuario, y existe")
    void existsTest() {
        StudentDTO studentDTO = new StudentDTO();

        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void notExistsTest() {
        StudentDTO studentDTO = new StudentDTO();
        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    void whenFindStudentByIdAndNotExistsThenThrowNotFoundException() {
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(id);
        });
    }

    @Test
    void WhenFindStudentByIdAndExistsThenReturnStudent() {
        StudentDTO expectedStudentDTO = new StudentDTO(6L, null, null, null, null);
        StudentDTO result = studentDAO.findById(6L);
        assertEquals(expectedStudentDTO, result);
    }

    @Test
    void WhenSaveStudentAndNotExists() {
        StudentDTO studentDTO = StudentDtoBuilder.buildBasicStudentDTO(id);
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void WhenDeleteExistedStudentThenReturnTrue(){
        assertTrue(studentDAO.delete(1L));
    }
}
