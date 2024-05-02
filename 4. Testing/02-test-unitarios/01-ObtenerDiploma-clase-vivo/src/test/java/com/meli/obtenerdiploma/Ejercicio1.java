package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio1 {

    private StudentDAO studentDAO;
    private Long id = 1L;
    private StudentDTO studentDTO;
    private boolean studentExists;

    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();

        studentDTO = new StudentDTO();

        studentDTO.setId(id);
        studentDTO.setStudentName("John Doe");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 9.0));

        studentDTO.setSubjects(subjectDTOList);

        studentExists = studentDAO.exists(studentDTO);
    }

    @Test
    @DisplayName("Guardar un nuevo alumno")
    void save_ValidStudent(){
        studentDAO.save(studentDTO);

        assertTrue(studentExists);
    }

    @Test
    @DisplayName("Guardar un nuevo alumno con datos invalidos")
    void save_invalidStudent(){
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    @DisplayName("Buscar un alumno por id")
    void findById_existingId(){
        studentDAO.save(studentDTO);
        boolean exists = studentDAO.exists(studentDAO.findById(id));

        assertTrue(exists);
    }

    @Test
    @DisplayName("Buscar un alumno por id no existente")
    void findById_nonExistingId(){
        Long nonExistingId = 1000L;

        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(nonExistingId));
    }

    @Test
    @DisplayName("Actualizar un alumno")
    void updateStudent(){
        Long studentId = studentDTO.getId();

        StudentDTO updatedStudentDTO = new StudentDTO();
        updatedStudentDTO.setId(studentId);
        updatedStudentDTO.setStudentName("Jane Doe");
        List<SubjectDTO> updatedSubjectDTOList = new ArrayList<>();
        updatedSubjectDTOList.add(new SubjectDTO("Matemática", 9.0));
        updatedSubjectDTOList.add(new SubjectDTO("Física", 8.0));
        updatedStudentDTO.setSubjects(updatedSubjectDTOList);

        studentDAO.save(updatedStudentDTO);

        StudentDTO retrievedStudent = studentDAO.findById(studentId);

        assertEquals(updatedStudentDTO,retrievedStudent);
    }

    @Test
    @DisplayName("Eliminar un alumno")
    void delete_validUser(){
        studentDAO.save(studentDTO);

        boolean deleted = studentDAO.delete(studentDTO.getId());

        assertTrue(deleted);
    }

    @Test
    @DisplayName("Eliminar un alumno con id null")
    void delete_nullId(){
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
    }

    @Test
    @DisplayName("Eliminar un alumno con id no existente")
    void delete_nonExistingId(){
        Long nonExistingId = 1000L;

        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(nonExistingId));
    }
}
