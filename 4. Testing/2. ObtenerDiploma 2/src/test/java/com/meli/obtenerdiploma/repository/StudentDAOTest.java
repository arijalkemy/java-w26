package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    private StudentDTO createStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("John Doe");
        student.setMessage("El alumno John Doe ha obtenido un promedio de 9. Puedes mejorar.");
        student.setAverageScore(9.0);
        return student;
    }

    @Test
    public void testSave() {
        StudentDTO student = createStudent();
        studentDAO.save(student);

        // Verificar que el estudiante fue guardado correctamente
        StudentDTO savedStudent = studentDAO.findById(student.getId());
        assertThat(savedStudent).isEqualTo(student);
    }

    @Test
    public void testDelete() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        boolean deleted = studentDAO.delete(student.getId());

        // Verificar que el estudiante fue eliminado correctamente
        assertThat(deleted).isTrue();
        assertThatThrownBy(() -> studentDAO.findById(student.getId()))
                .isInstanceOf(StudentNotFoundException.class);
    }

    @Test
    public void testExists() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        boolean exists = studentDAO.exists(student);

        // Verificar que el estudiante existe
        assertThat(exists).isTrue();
    }

    @Test
    public void testFindById() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        StudentDTO foundStudent = studentDAO.findById(student.getId());

        // Verificar que el estudiante fue encontrado correctamente
        assertThat(foundStudent).isEqualTo(student);
    }

    @Test
    public void testFindByIdNotFound() {
        // Verificar que se lanza una excepción cuando el estudiante no se encuentra
        assertThatThrownBy(() -> studentDAO.findById(999L))
                .isInstanceOf(StudentNotFoundException.class);
    }
}