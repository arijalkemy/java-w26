package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    @Test
    void save() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentModel = new StudentDTO(null, "Edwin",
                "Test Student",
                80.5,
                List.of(
                        new SubjectDTO("Math", 80.5),
                        new SubjectDTO("History", 43.5),
                        new SubjectDTO("Science", 30.5)
                )
        );
        // Act
        studentDAO.save(studentModel);
        StudentDTO savedStudent = studentDAO.findById(24L);
        // Assert
        assertEquals("Edwin", savedStudent.getStudentName());
        assertEquals(3, studentModel.getSubjects().size());
        assertEquals(80.5,studentModel.getAverageScore());
    }

    @Test
    void saveWhenStudentAlreadyExists() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO existingStudent = new StudentDTO(2L,
                "Rodrigo","Test Student 2",
                96.54,
                List.of(
                        new SubjectDTO("Math", 90.5),
                        new SubjectDTO("History", 83.8),
                        new SubjectDTO("Science", 67.3)
                ));
        studentDAO.save(existingStudent);

        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("New student");
        newStudent.setId(2L);
        // Act
        studentDAO.save(newStudent);
        StudentDTO savedStudent = studentDAO.findById(2L);
        // Assert
        assertEquals("New student", savedStudent.getStudentName());
        assertNotEquals("Existing student", savedStudent.getStudentName());
    }

    @Test
    void delete() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test student");
        studentDTO.setId(1L);
        studentDAO.save(studentDTO);

        // Act
        boolean isDeleted = studentDAO.delete(1L);

        // Assert
        assertTrue(isDeleted);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @Test
    void exists() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test student");
        studentDTO.setId(2L);

        // Act
        boolean exists = studentDAO.exists(studentDTO);
        
        // Assert
        assertTrue(exists);
    }

    @Test
    void findById() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test student");
        studentDTO.setId(2L);
        studentDAO.save(studentDTO);

        // Act
        StudentDTO foundStudent = studentDAO.findById(2L);

        // Assert
        assertEquals("Test student", foundStudent.getStudentName());
    }

    @Test
    void findByIdWhenStudentDoesNotExist() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("test student");
        studentDTO.setId(4L);
        studentDAO.save(studentDTO);

        // Act
        StudentDTO foundStudent = studentDAO.findById(3L);

        // Assert
        assertNotEquals(studentDTO.getStudentName(), foundStudent.getStudentName());
    }
}