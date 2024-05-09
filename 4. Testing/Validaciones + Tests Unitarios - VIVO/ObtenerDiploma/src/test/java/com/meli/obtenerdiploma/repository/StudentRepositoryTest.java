package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Set;

@SpringBootTest
@TestPropertySource(properties = {"api.scope=test"})
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;


    @Test
    @DisplayName("Get a set of student's DTO from resources/users.json")
    void findAllStudents() {

        Set<StudentDTO> loadedData = studentRepository.findAll();

        Assertions.assertEquals(2, loadedData.size());
    }

}
