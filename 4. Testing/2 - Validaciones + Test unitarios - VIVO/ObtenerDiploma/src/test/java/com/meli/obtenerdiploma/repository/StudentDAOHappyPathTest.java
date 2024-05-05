package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOHappyPathTest {

    @Autowired
    IStudentDAO studentDAO;

    @Test
    @DisplayName("it should add StudentDTO to the repository")
    public void saveTest(){
        // arrange
        StudentDTO studentDTO = new StudentDTO(
                0L,
                "Jose",
                "",
                0.0,
                Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        )
                )
        );

        // act
        studentDAO.save(studentDTO);

        // assert
        assertTrue(studentDAO.exists(studentDTO));
    }


    @Test
    @DisplayName("it should returns a StudentDTO by Id")
    public void findByIdTest(){
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);

        // act
        StudentDTO studentDtoResult = studentDAO.findById(studentDTO.getId());
        assertNotNull(studentDtoResult);

        // assert
        assertEquals(studentDtoResult.getId(), studentDTO.getId());
    }

    @Test
    @DisplayName("it should modify the data from a Student in the repository")
    public void saveModifyTest(){

    }
}
