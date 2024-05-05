package com.meli.obtenerdiploma.repository.happyPath;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryHappyPathTest {

    @Autowired
    IStudentRepository studentRepository;

    @Test
    @DisplayName("it should returns the list of the students")
    public void returnListOfStudenWhenFileExist(){
        // arrange
        Set<StudentDTO> listOfStudents = studentRepository.findAll();

        // act & assert
        assertNotNull(listOfStudents);
        assertFalse(listOfStudents.isEmpty());
    }
}
