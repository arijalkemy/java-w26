package meli.bootcamp.obtenerdiplomacrud.repository;

import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;
import meli.bootcamp.obtenerdiplomacrud.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    IStudentRepository studentRepository;

    @BeforeEach
    @AfterEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Find all students")
    void findAll() {
        Set<StudentDTO> obtained = studentRepository.findAll();

        assertEquals(3, obtained.size());
    }
}