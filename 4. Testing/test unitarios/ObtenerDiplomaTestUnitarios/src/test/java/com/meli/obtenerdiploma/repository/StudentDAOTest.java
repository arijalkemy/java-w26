package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDAOTest {
    private StudentDAO studentDao = new StudentDAO();

    private StudentDTO existingStudent;
    private StudentDTO notExistingStudent;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private StudentDAO studentDAO;

    private StudentDTO generateStudentDTO(String json) {
        StudentDTO student = null;
        try {
            student = objectMapper.readValue(json, StudentDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @BeforeEach
    public void setup() {
        String existingStudentJson = "{\"id\":1,\"studentName\":\"Juan\",\"subjects\":[{\"name\":\"Matemática\",\"score\":9},{\"name\":\"Física\",\"score\":7},{\"name\":\"Química\",\"score\":6}]}";
        String notExisitingStudentJson = "{\"id\":2000,\"studentName\":\"Hernan\",\"subjects\":[{\"name\":\"Matemática\",\"score\":9},{\"name\":\"Física\",\"score\":7},{\"name\":\"Química\",\"score\":6}]}";

        existingStudent = generateStudentDTO(existingStudentJson);
        notExistingStudent = generateStudentDTO(notExisitingStudentJson);
        studentDAO.save(existingStudent);
        studentDAO.save(notExistingStudent);
        studentDAO.delete(notExistingStudent.getId());
    }

    @Test
    @DisplayName("chek result with an existing student")
    public void studentDAOExistTest() {
        Assertions.assertEquals(true, studentDAO.exists(existingStudent));
    }

    @Test
    @DisplayName("chek result with an unexisting student")
    public void studentDAONotExistTest() {
        Assertions.assertEquals(false, studentDAO.exists(notExistingStudent));
    }

    @Test
    @DisplayName("save not existing user")
    public void saveNotExisitingUser(){
        studentDAO.save(notExistingStudent);
        StudentDTO insertedStudent = studentDAO.findById(notExistingStudent.getId());
        Assertions.assertEquals(insertedStudent, notExistingStudent);
    }


    @Test
    @DisplayName("check if an existing user can be deleted")
    public void studentDAODelete() {
        Assertions.assertEquals(true, studentDAO.delete(existingStudent.getId()));
    }

    @Test
    @DisplayName("check if an unexisting user can be deleted")
    public void studentDAONotExistingDelete() {
        Assertions.assertEquals(false, studentDAO.delete(notExistingStudent.getId()));
    }

    @Test
    @DisplayName("check if an exisiting user is founded by stuentDAO by id")
    public void studentFoundedByIdTest(){
        StudentDTO studentFounded = studentDAO.findById(existingStudent.getId());
        Assertions.assertEquals(existingStudent, studentFounded);
    }

    @Test
    @DisplayName("check if an unexisiting user serached by stuentDAO by id throws an exception")
    public void studentNotFoundedByIdTest(){
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(notExistingStudent.getId()));
    }
}
