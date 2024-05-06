package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDAOTest {
    private StudentRepository repository;

    @BeforeEach
    public void setup(){
        this.repository = new StudentRepository();
    }

    @Test
    public void findByIdTest(){
        
    }
}
