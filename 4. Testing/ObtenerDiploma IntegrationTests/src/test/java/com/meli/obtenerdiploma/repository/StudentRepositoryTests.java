package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;


    @BeforeEach @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

    @Test
    public void findAllFileNotFound() {
        // arrange
        Set<StudentDTO> foundSet;
        // act
        try (MockedStatic<ResourceUtils> mockedResourceUtils = Mockito.mockStatic(ResourceUtils.class)) {
            mockedResourceUtils.when(() -> ResourceUtils.getFile(anyString())).thenThrow(FileNotFoundException.class);
            foundSet = studentRepo.findAll();
        }

        // assert
        Assertions.assertTrue(foundSet.isEmpty());
    }


}
