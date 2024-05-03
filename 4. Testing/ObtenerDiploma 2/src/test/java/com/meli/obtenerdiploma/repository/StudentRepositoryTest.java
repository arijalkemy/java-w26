package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;


@SpringBootTest
class StudentRepositoryTest {

    IStudentRepository studentDAO = new StudentRepository();
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
    void findAllStudentWithEmpyDB(){
        Set<StudentDTO> studentDTOList = studentDAO.findAll();

        Assertions.assertTrue(studentDTOList.isEmpty());
    }



    @Test
    void findAllStudentsWithTwoStudentsInDB() throws IOException {
        StudentDTO student1 = new StudentDTO();
        student1.setId(1L);

        StudentDTO student2 = new StudentDTO();
        student2.setId(2L);

        File file = new File("./src/test/resources/users.json");

        objectMapper.writeValue(file, Set.of(student1, student2));

        Set<StudentDTO> studentDTOList = studentDAO.findAll();

        Assertions.assertEquals(2, studentDTOList.size());
        Assertions.assertTrue(studentDTOList.contains(student1));
        Assertions.assertTrue(studentDTOList.contains(student2));
    }

}