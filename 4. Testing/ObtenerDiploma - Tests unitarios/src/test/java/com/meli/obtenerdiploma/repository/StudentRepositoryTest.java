package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StudentRepositoryTest {

    IStudentRepository studentRepository;


    @BeforeEach
    void setup(){
        this.studentRepository = new StudentRepository();
        System.out.println(studentRepository.findAll());
    }

    @Test
    @DisplayName("Test for all students")
    public void findAll() {
//        Arrange
        Set<StudentDTO> data = studentRepository.findAll();

//        Act & and Arrange
        assertThat(data).isNotNull();
    }
}