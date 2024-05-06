package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTests {

    IStudentRepository studentRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void testFindAllStudents() {

        Set<StudentDTO> foundStudents = studentRepository.findAll();

        assertEquals(0, foundStudents.size());
    }
}
