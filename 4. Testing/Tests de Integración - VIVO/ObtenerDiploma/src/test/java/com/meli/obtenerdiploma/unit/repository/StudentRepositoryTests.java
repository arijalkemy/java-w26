package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.KeeperState;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.Set;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach
    private void setUp() throws FileNotFoundException {
        KeeperState.copySnapShoot("users.json");
        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @AfterEach
    private void tearDown() {
        KeeperState.redoSnapShoot();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

}
