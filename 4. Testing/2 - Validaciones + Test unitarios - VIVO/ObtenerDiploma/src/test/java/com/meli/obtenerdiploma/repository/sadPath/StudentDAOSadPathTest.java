package com.meli.obtenerdiploma.repository.sadPath;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOSadPathTest {
    @Autowired
    IStudentDAO studentDAO;


    @Test
    @DisplayName("it should returns a exception 'StudentNoFoundException' when Student is not found by Id in findById")
    public void getStudentById(){
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(12L);

        // act & assert
        assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(studentDTO.getId())
        );
    }

    @Test
    @DisplayName("it should returns a exception 'false' when Student is not found in exist method")
    public void existStudentById(){
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);

        //
        boolean studentFound = studentDAO.exists(studentDTO);

        // assert
        assertFalse(studentFound);
    }
}
