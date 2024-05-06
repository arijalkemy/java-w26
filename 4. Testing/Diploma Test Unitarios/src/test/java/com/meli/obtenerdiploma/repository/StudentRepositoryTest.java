package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.CompareSets;
import com.meli.obtenerdiploma.util.InitialDataTest;
import org.junit.jupiter.api.*;

import java.util.*;

public class StudentRepositoryTest {

    private IStudentRepository studentRepository;
    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp(){
        studentRepository = new StudentRepository();
        studentDAO = new StudentDAO();
        InitialDataTest.resetFile();
    }

    @AfterEach
    void tearDown(){
        InitialDataTest.resetFile();
    }

    @Test
    @DisplayName("Obtener todas los alumnos del repositorio")
    public void getAllStudents(){
        //Arrange
        InitialDataTest.blankFile();
        studentDAO.saveAll(newSet());

        //Act
        Set<StudentDTO> all = studentRepository.findAll();

        //Asert
        Assertions.assertTrue(CompareSets.compare(newSet(),all));
    }

    //Creamos una nueva lista para saber si el repositorio la puede devolver
    Set<StudentDTO> newSet(){
        Set<StudentDTO> newStudents= new LinkedHashSet<>();
        newStudents.add(new StudentDTO(1L,"Camilo Perez","",0.0,
                List.of(new SubjectDTO("Finanzas",10.0))));

        newStudents.add(new StudentDTO(2L,"Armando Paredes","",0.0,
                List.of(new SubjectDTO("Religión",10.0),
                new SubjectDTO("Dibujo Técnico",8.0))));

        return newStudents;
    }




}
