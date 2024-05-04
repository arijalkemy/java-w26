package com.meli.obtenerdiploma.units.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }
    @AfterAll
    static void tearDown() {
        TestUtils.deleteInfoRepository();
    }

    @Test
    @DisplayName("Devuelve todos los estudiantes que encuentre en el repositorio")
    public void devolverTodosLosEstudiantesTest() {
        Set<StudentDTO> expected = new HashSet<>(TestUtils.loadData());
        Set<StudentDTO> output = studentRepository.findAll();
        Assertions.assertTrue(expected.containsAll(output));
    }
}
