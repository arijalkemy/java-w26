package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    public void setup() {
        studentRepository = new StudentRepository();
        // Aquí puedes configurar cualquier cosa que necesites para tu entorno de prueba,
        // como una base de datos de prueba o datos de prueba.
    }

    @Test
    public void findAllTest() {
        assertNotNull(studentRepository.findAll());
    }
}
