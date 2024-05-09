package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setup(){
         this.studentDAO = new StudentDAO();
    }

    @Test
    void agregarUnAlumno(){


        studentDAO.save();
    }
}
