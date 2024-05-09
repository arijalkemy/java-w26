package com.meli.obtenerdiploma.integración.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudenControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO(3L, "Juan","", 0D, List.of(
                new SubjectDTO("Matematicas", 7D),
                new SubjectDTO("Fisica", 9D),
                new SubjectDTO("Quimica", 6D)
        ));

        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        MvcResult mvcResult= mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();
    }
}
