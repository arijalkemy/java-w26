package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class StudentDAOTest {

    private StudentDAO studentDAO;
    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();

        // The object to be used in the tests is instantiated
        studentDTO = StudentDTO.builder()
                .studentName("Juan Perez")
                .subjects(List.of(new SubjectDTO("Mathematics", 4D),
                        new SubjectDTO("English", 7D)))
                .build();
    }

    @Test
    @DisplayName("Student successful save")
    void successfulSaveTest() {
        // arrange
        Long userIdExpected = studentDAO.ultimateIdStudent() + 1;

        // act
        studentDAO.save(studentDTO); // The object is saved
        studentDTO.setId(userIdExpected); // It is assigned to the ID to be validated

        // assert
        Assertions.assertTrue(studentDAO.exists(studentDTO)); // It validates if the object exists
    }

    @Test
    @DisplayName("Delete student successfully")
    void deleteStudentSuccessful(){
        // arrange
        studentDTO.setId(studentDAO.ultimateIdStudent()); // Id student to delete

        //act
        boolean result = studentDAO.delete(studentDTO.getId());

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Delete student does not exist")
    void notFoundStudentToDeleteException(){
        // arrange
        studentDTO.setId(9999L); // Student ID that does not exist

        //act
        boolean result = studentDAO.delete(studentDTO.getId());

        // assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Validate student existence")
    void existsStudentSuccess(){
        // arrange
        studentDTO.setId(studentDAO.ultimateIdStudent());

        // act
        boolean result = studentDAO.exists(studentDTO);

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("validate student not existence")
    void existsStudentUnsuccessful(){
        // arrange
        studentDTO.setId(9999L);

        // act
        boolean result = studentDAO.exists(studentDTO);

        // assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Find student by id successful")
    void findByIdSuccessful(){
        // arrange
        studentDTO.setId(studentDAO.ultimateIdStudent());

        // act
        StudentDTO studentDTOExpect = studentDAO.findById(studentDTO.getId());

        // assert
        Assertions.assertEquals(studentDTO.getId(), studentDTOExpect.getId());
        Assertions.assertEquals(studentDTO.getStudentName(), studentDTOExpect.getStudentName());
    }

    @Test
    @DisplayName("Find student by id exception not found")
    void findById_StudentNotFoundException(){
        // arrange
        studentDTO.setId(9999L);

        // act y assert
        Long studentId = studentDTO.getId();
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(studentId));
        verify(studentDAO, atLeastOnce()).findById(studentId);
    }

}