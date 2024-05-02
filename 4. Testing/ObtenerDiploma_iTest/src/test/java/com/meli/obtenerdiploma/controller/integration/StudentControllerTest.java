package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        mapper = new ObjectMapper();
    }

    /**
     * TESTS for register student
     * /student/registerStudent
     */
    @Test
    @DisplayName("Successful case registering a user")
    void registerStudentTestOk() throws Exception {
        // Given - Arrange
        StudentDTO studentToAdd = TestUtilsGenerator.getUserJsonRecord(1L);

        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentToAdd))
        );
//        MvcResult result = response.andReturn();

        // Then - Assert
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * TESTS for get student
     * /student/getStudent/{id}
     */
    @Test
    @DisplayName("Successful case getting a student")
    void getStudentTestOk() {
        // Given - Arrange

        // When - Act

        // Then - Assert

    }

    /**
     * TESTS for modify student
     * /student/modifyStudent
     */
    @Test
    @DisplayName("Successful case modifying a student")
    void modifyStudentOk() {
        // Given - Arrange

        // When - Act

        // Then - Assert

    }

    /**
     * TESTS for remove student
     * /student/removeStudent/{id}
     */
    @Test
    @DisplayName("Successful case removing a student")
    void removeStudentOk() {
        // Given - Arrange

        // When - Act

        // Then - Assert

    }

    /**
     * TESTS for list students
     * /student/listStudents
     */
    @Test
    @DisplayName("Successful get list of students")
    void listStudentsOk() {
        // Given - Arrange

        // When - Act

        // Then - Assert

    }
}
