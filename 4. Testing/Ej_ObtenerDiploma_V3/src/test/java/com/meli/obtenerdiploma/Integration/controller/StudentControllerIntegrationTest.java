package com.meli.obtenerdiploma.Integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter WRITER;

    @BeforeAll
    static void init() {
        WRITER = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        
    }

    @BeforeEach
    void loadStudents(){
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWithId(1L));
    }

    @Test
    @DisplayName("Success register student")
    void whenRegisterStudentSuccesfull() throws JsonProcessingException, Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/registerStudent")
                        .content(WRITER.writeValueAsString(studentDTO)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Invalid name register student")
    void whenRegisterStudentWithInvalidNameLengthReturnBadRequest() throws JsonProcessingException, Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro".repeat(50));
        this.mockMvc
            .perform(MockMvcRequestBuilders
                .post("/student/registerStudent")
                .content(WRITER.writeValueAsString(studentDTO))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));           
    }

    @Test
    @DisplayName("Find existing user by id")
    void whenGetExistingStudentByIdThenReturnOkAndStudent() throws Exception{
        Long id = 1L;
        StudentDTO expectedStudentDTO = TestUtilsGenerator.getStudentWithId(id);
        MvcResult result = this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}",id))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andReturn();
        
        result.getResponse().setCharacterEncoding("UTF-8");
        assertEquals(WRITER.writeValueAsString(expectedStudentDTO), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Not found existing user")
    void whenGetNotExistingUserByIdThenReturnNotFound() throws Exception{
        Long id = Long.MAX_VALUE;
        this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}",id))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id " + id + " no se encuetra registrado."))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    
}
