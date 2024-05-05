package com.meli.obtenerdiploma.unit.repository;
import com.meli.obtenerdiploma.exception.StudentAlreadyExists;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.KeeperState;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

import lombok.extern.java.Log;


import java.io.FileNotFoundException;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.*;

@Log
public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach
    private void setUp() throws FileNotFoundException {

       KeeperState.copySnapShoot("users.json");
       this.studentDAO = new StudentDAO();
    }

    @AfterEach
    private void tearDown()
    {
        KeeperState.redoSnapShoot();
    }

    @Test
    @DisplayName("Test for create a student not existent")
    public void createNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        int studentsBeforeInsert = studentDAO.count();
        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertEquals(studentsBeforeInsert+1, studentDAO.count());
        Assertions.assertTrue(studentDAO.exists(stu.getStudentName()));
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void createExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getFirstStudent();
        int studentsBeforeInsert = studentDAO.count();

        // Act and Assertion
        Assertions.assertThrows(StudentAlreadyExists.class, ()->{
            studentDAO.save(stu);
        });

        //Rest Assertions
        Assertions.assertEquals(studentsBeforeInsert, studentDAO.count());
        Assertions.assertTrue(studentDAO.exists(stu.getId()));
    }

    @Test
    public void modifyNonExistentStudent() {
        // Arrange
        StudentDTO stu1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        int countStudents = studentDAO.count();

        // Act

        studentDAO.save(stu1);

        // Assert
        
        Assertions.assertEquals(countStudents+1, studentDAO.count());
        Assertions.assertTrue(studentDAO.exists(stu1.getStudentName()));
        Assertions.assertEquals(stu1, studentDAO.findById(stu1.getId()));
        log.info(stu1.getId()+"ID");
    }

    @Test
    public void modifyExistentStudent() throws CloneNotSupportedException { 
        // Arrange
        StudentDTO studentBase = SerializationUtils.clone(studentDAO.findById(1L));

        StudentDTO studentExpected = SerializationUtils.clone(studentBase);
        studentExpected.setStudentName("Marco Polo");

        int countStudents = studentDAO.count();


        // Act
        
        StudentDTO studentModify = SerializationUtils.clone(studentBase);
        studentModify.setStudentName("Marco Polo");

        studentDAO.update(studentModify);
        //log.info(studentBase.hashCode()+" BASE");
        //log.info(studentExpected.hashCode()+" Expected");
        //log.info(studentModify.hashCode()+" Modify");
        // Assert
        Assertions.assertEquals(countStudents, studentDAO.count());

        Assertions.assertTrue(studentDAO.exists(studentExpected.getId()));
        log.info(studentExpected.toString() + " EX");
        log.info(studentDAO.findById(studentBase.getId()).toString() + "GET");
        Assertions.assertEquals(studentExpected, studentDAO.findById(studentBase.getId()));
    }

    @Test
    public void findExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        StudentDTO found = studentDAO.findById(stu.getId());

        // assert
        Assertions.assertEquals(found, stu);
    }

    @Test
    public void findNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu.getId()));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu.getId()));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }



}
