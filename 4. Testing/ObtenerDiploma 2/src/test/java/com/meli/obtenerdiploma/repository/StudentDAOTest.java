package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestComponent
public class StudentDAOTest {
    private StudentTestDAO studentDAO;
    private List<SubjectDTO> materias;

    @BeforeEach
    void setupTest(){
        studentDAO = new StudentTestDAO();
        materias = new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Logica", 8.0));
            }
        };
    }

    @Test
    void addStudent(){
        studentDAO.save(new StudentDTO(1L,"Juan", "Perez", 10.0, materias));
    }

    @Test
    void testGetStudentById(){
        StudentDTO student = new StudentDTO(1L,"Juan", "Perez", 10.0, materias);
        studentDAO.save(student);
        assertEquals(student, studentDAO.findById(1L));
    }

    @Test
    void testGetStudentByNonExistentId(){
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(10L);
        });
    }

    @Test
    void testExistsStudent(){
        assertTrue(studentDAO.exists(new StudentDTO(1L,"Juan", "Perez", 10.0, materias)));
    }
}
