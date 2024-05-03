package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    public void findAllStudentsSuccessfuly() {
        // Arrange
        Set<StudentDTO> expectedResult = TestUtils.createStudentsSet();

        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertTrue(CollectionUtils.isEqualCollection(expectedResult, result));
    }
}
