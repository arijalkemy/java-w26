package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDaoRepositoryTest {

    StudentDAO studentDAORepository = new StudentDAO();
    private StudentDTO student;

    @BeforeEach
    public void setUp() {
        student = StudentDTO.builder()
                .id(1L)
                .studentName("Joaquin")
                .message("Test")
                .averageScore(90.0)
                .subjects(Arrays.asList(
                        SubjectDTO.builder().name("Math").score(90.0).build(),
                        SubjectDTO.builder().name("Science").score(90.0).build()
                ))
                .build();
    }

    @Test
    public void saveStudentThenAndFindById(){
        // Act
        studentDAORepository.save(student);
        // Assert
        StudentDTO foundStudent = studentDAORepository.findById(student.getId());
        Assertions.assertEquals(student, foundStudent);
    }

    @Test
    public void findByIdGlobalStudentAndItsSame (){
        // Act
        StudentDTO foundStudent = studentDAORepository.findById(student.getId());
        // Assert
        assertEquals(student, foundStudent);
    }

    @Test
    public void findByIdThrowsExceptionWhenIdDoesNotExistTest(){
        // Act and Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAORepository.findById(999L)); // un id que no existe en el repositorio
    }

    @Test
    public void deleteStudentExpectThrowStudentNotFoundExceptionTest(){
        // Act
        StudentDTO toDelete = studentDAORepository.findById(student.getId());
        studentDAORepository.delete(student.getId());

        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAORepository.findById(student.getId()));
    }
}