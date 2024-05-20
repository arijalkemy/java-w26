package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private IStudentDAO studentDAO;

    @BeforeEach
    public void setup() {
        studentDAO = new TestStudentDAO();
    }

    @Test
    public void saveTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDAO.save(studentDTO);

        StudentDTO savedStudent = studentDAO.findById(1L);
        assertEquals(1L, savedStudent.getId());
    }

    @Test
    public void deleteTest() {
        // Crear un StudentDTO y guardarlo
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDAO.save(studentDTO);

        // Verificar que el StudentDTO está en el TestStudentDAO
        StudentDTO savedStudent = studentDAO.findById(1L);
        assertEquals(1L, savedStudent.getId());

        // Llamar al método delete() con el ID del StudentDTO
        boolean deleted = studentDAO.delete(1L);

        // Verificar que delete() devolvió true
        assertTrue(deleted);
    }

    @Test
    public void existsTest() {
        // Crear un StudentDTO y guardarlo
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDAO.save(studentDTO);

        // Verificar que el StudentDTO está en el TestStudentDAO
        boolean exists = studentDAO.exists(studentDTO);
        assertTrue(exists);

        // Crear otro StudentDTO que no está en el TestStudentDAO
        StudentDTO anotherStudentDTO = new StudentDTO();
        anotherStudentDTO.setId(2L);

        // Verificar que el otro StudentDTO no está en el TestStudentDAO
        boolean anotherExists = studentDAO.exists(anotherStudentDTO);
        assertFalse(anotherExists);
    }

    @Test
    public void findByIdTest() {
        // Crear un StudentDTO y guardarlo
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDAO.save(studentDTO);

        // Verificar que el StudentDTO está en el TestStudentDAO
        StudentDTO foundStudent = studentDAO.findById(1L);
        assertEquals(1L, foundStudent.getId());

        // Verificar que un StudentDTO que no está en el TestStudentDAO devuelve null
        StudentDTO notFoundStudent = studentDAO.findById(2L);
        assertNull(notFoundStudent);
    }
}
