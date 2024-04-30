package com.testing.obtenerdiploma_unit_mocks.repository;

import com.testing.obtenerdiploma_unit_mocks.exception.StudentNotFoundException;
import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;
import com.testing.obtenerdiploma_unit_mocks.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        this.studentDAO = new StudentDAO();
    }

    // this.studentDAO.save(studentDTO);
    @Test
    void save() {
        StudentDTO studentDTO = new StudentDTO(123123123L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        this.studentDAO.save(studentDTO);
        assertEquals(6, studentDTO.getId());
    }

    // this.studentDAO.delete(1L);

    @Test
    @DisplayName("Borrar un alumno que existe")
    void deleteExistingAlumno() {
        Long id = 1L;
        assertTrue(this.studentDAO.delete(id));
    }

    @Test
    @DisplayName("Borrar un alumno que NO existe")
    void deleteNotExistingAlumno() {
        Long id = 10L;
        assertFalse(this.studentDAO.delete(id));
    }

    // ---- this.studentDAO.exists(dto)

    @Test
    @DisplayName("Alumno DTO existe")
    void existsStudentDTOJuan() {
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        assertTrue(this.studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Alumno DTO no existe")
    void StudentDTOJuanDoesNotExist() {
        StudentDTO studentDTO = new StudentDTO(
                0L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0)
                )
        );
        assertFalse(this.studentDAO.exists(studentDTO));
    }

    // ---- this.studentDAO.findById(id)
    @Test
    @DisplayName("Encontrar al estudiante con id 1")
    void findStudenByIdOne() {
        Long studentId = 1L;
        assertInstanceOf(StudentDTO.class,this.studentDAO.findById(studentId));
    }

    @Test
    @DisplayName("Error StudentNotFoundException con estudiante con id 0")
    void findStudenByNotExistingId() {
        Long studentId = 0L;

        StudentNotFoundException exception =
                assertThrows(StudentNotFoundException.class, () -> this.studentDAO.findById(studentId));

        assertEquals(
                "El alumno con Id " + studentId + " no se encuetra registrado.",
                exception.getError().getDescription()
        );
    }
}