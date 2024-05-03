package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();


    private List<SubjectDTO> list= new ArrayList<>();
    private List<SubjectDTO> list2= new ArrayList<>();


    @BeforeEach
    public void setup(){

        list.add(new SubjectDTO("Matemática", 9.0));
        list.add(new SubjectDTO("Física", 7.0));
        list.add(new SubjectDTO("Química", 6.0));

        list2.add(new SubjectDTO("Matemática", 10.0));
        list2.add(new SubjectDTO("Física", 8.0));
        list2.add(new SubjectDTO("Química", 4.0));
    }

    @Test
    public void findAll(){

        Set<StudentDTO> esperado= new HashSet<>();
        esperado.add(new StudentDTO(1L, "Juan", "", 0.0, list));
        esperado.add(new StudentDTO(2L, "Pedro", "", 0.0, list2));

        Set<StudentDTO> resultado= studentRepository.findAll();

        assertEquals(esperado, resultado);

    }
}
