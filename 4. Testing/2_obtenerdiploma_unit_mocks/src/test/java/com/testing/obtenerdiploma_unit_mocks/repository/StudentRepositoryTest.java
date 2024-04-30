package com.testing.obtenerdiploma_unit_mocks.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {"api.scope=test"})
class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;

    @Test
    void repoHasItems() {
        assertFalse(this.studentRepository.findAll().isEmpty());
    }

}