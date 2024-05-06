package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setup(){
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Se hace el test del metodo delete con un alumno existente")
    public void deleteTrueTest(){

        long idStudent = 1;

        boolean result = this.studentDAO.delete(idStudent);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Se hace el test del metodo delete con un alumno no existente")
    public void deleteFalseTest(){
        long idStudent = 5;

        boolean result = this.studentDAO.delete(idStudent);

        Assertions.assertFalse(result);
    }

}
