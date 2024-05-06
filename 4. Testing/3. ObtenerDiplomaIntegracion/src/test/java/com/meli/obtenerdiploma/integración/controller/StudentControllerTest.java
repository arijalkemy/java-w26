package com.meli.obtenerdiploma.integración.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Register student")
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

    @Test
    @DisplayName("Find student by id")
    void getStudent() throws Exception {
        long id = 1;
        mockMvc.perform(get("/student/getStudent/{id}", id))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, studentName: 'Juan'}"));
    }

    @Test
    @DisplayName("Find student by id not found")
    void getStudentError() throws Exception {
        long id = 5;
        mockMvc.perform(get("/student/getStudent/{id}", id))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException));
    }

    @Test
    void modifyStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO(3L, "Jose",null, null, List.of(
                new SubjectDTO("Matematicas", 9D),
                new SubjectDTO("Fisica", 9D),
                new SubjectDTO("Quimica", 10D)
        ));

        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();
    }

    @Test
    void removeStudent() {
    }

    @Test
    void listStudents() {
    }
}