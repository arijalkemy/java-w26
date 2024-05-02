package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
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

        // Then - Assert
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Error case registering a user with invalid payload")
    void registerStudentTestInvalid() throws Exception {
        // Given - Arrange
        StudentDTO studentToAdd = new StudentDTO();

        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .content(writer.writeValueAsString(studentToAdd))
                        .contentType(MediaType.APPLICATION_JSON)
        );
        MvcResult result = response.andReturn();

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
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
