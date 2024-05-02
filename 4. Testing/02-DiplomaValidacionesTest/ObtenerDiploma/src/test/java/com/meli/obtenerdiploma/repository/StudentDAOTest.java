package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.meli.obtenerdiploma.util.UtilStudentGenerator.*;


public class StudentDAOTest {
    //inyecto studentDao para así poder acceder a sus metodos y testearlos
    IStudentDAO studentDAO;

    @BeforeEach
    private void setUp(){

        this.studentDAO =  new StudentDAO();
    }

    @Test
    @DisplayName("Save Student Test")
    public void saveStudentTest(){
        //arrange
        StudentDTO student = studentWithoutId("Juan Perez");

        //act
        studentDAO.save(student);

        //assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(student, studentDAO.findById(student.getId()));

    }

    @Test
    @DisplayName("Delete Student Test")
    public void deleteStudentTest(){
        //arrange
        StudentDTO student = studentWithoutId("Mario Gomez");
        studentDAO.save(student);

        //act
        studentDAO.delete(student.getId());

        //assert
        Assertions.assertFalse(studentDAO.exists(student));
    }
}
