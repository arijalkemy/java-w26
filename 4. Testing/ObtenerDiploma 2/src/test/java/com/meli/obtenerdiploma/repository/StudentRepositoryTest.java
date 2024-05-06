package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestComponent
public class StudentRepositoryTest {
    private StudentTestRepository studentTestRepository;

    private Set<StudentDTO> students;

    @BeforeEach
    public void setUp(){
        studentTestRepository = new StudentTestRepository();

        List<SubjectDTO> subjects = new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Logica", 8.0));
            }
        };

        students = new HashSet<>(){
            {
                add(new StudentDTO(1L,"Juan", "Perez", 10.0, subjects));
                add(new StudentDTO(2L,"Maria", "Gomez", 9.0, subjects));
                add(new StudentDTO(3L,"Pedro", "Lopez", 8.0, subjects));
            }
        };
    }

    @Test
    public void testFindAll(){
        assertEquals(students, studentTestRepository.findAll());
    }

}
