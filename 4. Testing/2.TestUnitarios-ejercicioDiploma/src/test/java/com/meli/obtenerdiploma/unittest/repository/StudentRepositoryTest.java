package com.meli.obtenerdiploma.unittest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@EqualsAndHashCode
public class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;

    @Value("test")
    private String SCOPE;

    @Test
    public void findAllStudentsTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<StudentDTO> data = new HashSet<>();

        File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
        data = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});

        //ACT
        Set<StudentDTO> result = studentRepository.findAll();

        //ASSERT
        Assertions.assertEquals(data.size(), result.size());

    }
}
