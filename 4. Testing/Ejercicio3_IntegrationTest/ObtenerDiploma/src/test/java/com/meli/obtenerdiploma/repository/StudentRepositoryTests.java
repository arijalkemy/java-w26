package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        TestUtilsGenerator.usersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        StudentDTO stu = new StudentDTO();
        stu.setId(2L);
        stu.setStudentName("Pedro");
        stu.setSubjects(subjects);
        stu.setMessage(null);
        stu.setAverageScore(null);
        Set<StudentDTO> students = new HashSet<>();
        students.add(TestUtilsGenerator.getStudentExistent());
        students.add(stu);

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertEquals(students.size(), foundSet.size());
    }

}
