package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class StudentRepositoryTest {

    private StudentRepository studentRepository;
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("find All students successful")
    void findAllStudentsTest() {
        // arrange
        Set<StudentDTO> studentDTOs = TestUtilsGenerator.getStudentSet();
        studentDTOs.forEach(studentDTO -> studentDAO.save(studentDTO));

        // act
        Set<StudentDTO> resultStudentDTOs = studentRepository.findAll();

        // assert
        assertTrue(resultStudentDTOs.stream().anyMatch(
                studentDTO -> new ArrayList<>(studentDTOs)
                        .get(0).getStudentName().equals(studentDTO.getStudentName())));

    }

}