package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private static ObjectMapper mapper;


    @BeforeAll
    public static void setUpBeforeAll() {
        writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

        mapper = new ObjectMapper();
    }

    @Test
    public void registerNewStudentTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        StudentDTO student = TestUtilsGenerator.getNewStudent();
        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc
            .perform(
                post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    public void registerNewStudentMethodArgumentNotValidExceptionTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        StudentDTO studentError = new StudentDTO(1L, "", "", 0.0, new ArrayList<>());
        String payloadJson = writer.writeValueAsString(studentError);

        this.mockMvc
            .perform(
                post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    public void registerNewStudentHttpMessageNotReadableExceptionTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();

        this.mockMvc
            .perform(
                post("/student/registerStudent"))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    public void getStudentFoundTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.loadData(TestUtilsGenerator.getStudents());
        Long id = 1L;

        this.mockMvc
            .perform(
                get("/student/getStudent/{id}", id))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();
    }

    @Test
    public void getStudentNotFoundTest() throws Exception {
        this.mockMvc
            .perform(
                get("/student/getStudent/{id}", 99999L))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    public void modifyStudentSuccessTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.loadData(TestUtilsGenerator.getStudents());

        StudentDTO student = TestUtilsGenerator.getStudentWithId(1L);
        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc
            .perform(
                post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    public void removeStudentSuccessTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.loadData(TestUtilsGenerator.getStudents());

        this.mockMvc
            .perform(
                get("/student/removeStudent/{id}", 1L))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    public void removeStudentNotFoundOkTest() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.loadData(TestUtilsGenerator.getStudents());

        this.mockMvc
            .perform(
                get("/student/removeStudent/{id}", 99999L))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void listStudentsFoundOk() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        Set<StudentDTO> students = TestUtilsGenerator.getStudents();
        TestUtilsGenerator.loadData(students);

        MvcResult response = this.mockMvc
            .perform(MockMvcRequestBuilders.get("/student/listStudents"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();

        List<StudentDTO> studentsResponse = mapper.readValue(response.getResponse().getContentAsString(), List.class);
        Assertions.assertFalse(studentsResponse.isEmpty());
        Assertions.assertEquals(students.size(), studentsResponse.size());
        Assertions.assertEquals(
            writer.writeValueAsString(students),
            writer.writeValueAsString(studentsResponse)
        );
    }

    @Test
    public void listStudentsEmptyOk() throws Exception {
        TestUtilsGenerator.emptyUsersFile();

        MvcResult response = this.mockMvc
            .perform(MockMvcRequestBuilders.get("/student/listStudents"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();

        List<StudentDTO> studentsResponse = mapper.readValue(response.getResponse().getContentAsString(), List.class);
        Assertions.assertTrue(studentsResponse.isEmpty());
    }
}
