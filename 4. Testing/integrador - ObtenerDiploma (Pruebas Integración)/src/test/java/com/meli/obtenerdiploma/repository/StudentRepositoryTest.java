package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    public void setup(){
        this.studentRepository = new StudentRepository();
    }


    @Test
    @DisplayName("Test de repositorio de estudiantes")
    public void studentRepositoryFindAllTest(){
        //Arrange
        Set<StudentDTO> students = new HashSet<>();
        //Act
        students = studentRepository.findAll();
        //Assert
        assertNotNull(students);
    }

}