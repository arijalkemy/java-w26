package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOHappyPathTest {

    @Mock
    IStudentDAO studentDAO;

    @BeforeEach
    public void setup(){
        this.studentDAO = new StudentDAO();
    }

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
        System.out.println(studentDtoResult.getStudentName());

        // assert
        assertNotNull(studentDtoResult);
        assertEquals(studentDtoResult.getId(), studentDTO.getId());
    }
}
