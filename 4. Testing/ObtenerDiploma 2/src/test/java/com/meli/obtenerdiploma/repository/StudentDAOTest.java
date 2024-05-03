package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@SpringBootTest
class StudentDAOTest {

    IStudentDAO studentDAO = new StudentDAO();
    static ObjectWriter objectWriter;
    static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void setUpAll() throws IOException {

        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        File file = new File("./src/test/resources/users.json");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();

        objectMapper.writeValue(file, Set.of());
    }

    @AfterEach
    void tearDownAll() throws IOException {
        File file = new File("./src/test/resources/users.json");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();

        objectMapper.writeValue(file, Set.of());
    }

    @Test
    void saveAStudentTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        studentDAO.save(student);

        Assertions.assertTrue(studentDAO.exists(student));
    }

    @Test
    void deleteAStudentTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        studentDAO.save(student);

        Assertions.assertTrue(studentDAO.delete(student.getId()));
    }

    @Test
    void deleteAStudentThatDoesntExistTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        studentDAO.save(student);

        Assertions.assertFalse(studentDAO.delete(2L));
    }

    @Test
    void existsUserTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        studentDAO.save(student);

        Assertions.assertTrue(studentDAO.exists(student));
    }

    @Test
    void existsUserThatDoesntExistTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);

        Assertions.assertFalse(studentDAO.exists(student));
    }

    @Test
    void findByIdTest() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        studentDAO.save(student);

        Assertions.assertEquals(student, studentDAO.findById(student.getId()));
    }

    @Test
    void findByIdThatDoesntExistTest() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(2L));
    }
}