package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    public void setUp() throws JsonProcessingException {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> {
            studentDAO.save(stu);
            System.out.println(stu.getStudentName());
        });

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();
        foundSet.forEach(st -> System.out.println(st.getStudentName()));

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

}
