package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.StudentUtils;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        TestUtilsGenerator.emptyUsersFile();
        StudentUtils.createTestStudents().forEach(TestUtilsGenerator::appendNewStudent);
    }

    @AfterEach
    public void teardown() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void registerStudentOk() throws Exception {

        StudentDTO inputStudent = StudentUtils.createCommonStudent(null);
        String inputStudentJson = new ObjectMapper().writeValueAsString(inputStudent);

        mockMvc
            .perform(
                post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(inputStudentJson)
            )
            .andExpect(status().isOk())
            .andExpect(content().string(""));
    }

    @Test
    public void registerStudentInvalidData() throws Exception {

        StudentDTO inputStudent = StudentUtils.createCommonStudent(null);
        inputStudent.setStudentName("nombre de estudiante en minúscula");
        String inputStudentJson = new ObjectMapper().writeValueAsString(inputStudent);

        ErrorDTO expectedResponse = new ErrorDTO(
            "MethodArgumentNotValidException",
            "El nombre del estudiante debe comenzar con mayúscula."
        );
        String expectedResponseJson = new ObjectMapper().writeValueAsString(expectedResponse);

        mockMvc
            .perform(
                post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(inputStudentJson)
            )
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedResponseJson));
    }

    @Test
    public void registerStudentMalformedBody() throws Exception {

        StudentDTO inputStudent = StudentUtils.createCommonStudent(null);
        String inputStudentJson = new ObjectMapper().writeValueAsString(inputStudent);
        inputStudentJson = inputStudentJson.split(",")[0];

        mockMvc
            .perform(
                post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(inputStudentJson)
            )
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"))
            .andExpect(jsonPath("$.description").value(startsWith("JSON parse error")));
    }

    @Test
    public void getStudentReturnsCorrectStudent() throws Exception {

        long studentId = 1;

        StudentDTO expectedResponse = new StudentDTO(
            studentId,
            "Juan",
            null,
            null,
            List.of(
                new SubjectDTO("Ingles", 4.0),
                new SubjectDTO("Lengua", 0.0)
            )
        );
        String expectedResponseJson = new ObjectMapper().writeValueAsString(expectedResponse);

        mockMvc
            .perform(get("/student/getStudent/{studentId}", studentId))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedResponseJson));
    }

    @Test
    public void getNonExistentStudentReturnsNotFound() throws Exception {

        long studentId = 100;

        ErrorDTO expectedResponse = new ErrorDTO(
            StudentNotFoundException.class.getSimpleName(),
            "El alumno con Id %d no se encuetra registrado.".formatted(studentId)
        );
        String expectedResponseJson = new ObjectMapper().writeValueAsString(expectedResponse);

        mockMvc
            .perform(get("/student/getStudent/{studentId}", studentId))
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedResponseJson));
    }

    @Test
    public void modifyStudentOk() throws Exception {

        StudentDTO inputStudent = StudentUtils.createTestStudents().stream().findFirst().orElseThrow();
        inputStudent.setStudentName("Pepito");
        String inputStudentJson = new ObjectMapper().writeValueAsString(inputStudent);

        mockMvc
            .perform(
                post("/student/modifyStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(inputStudentJson)
            )
            .andExpect(status().isOk())
            .andExpect(content().string(""));
    }

    @Test
    public void removeStudentOk() throws Exception {

        mockMvc
            .perform(get("/student/removeStudent/{id}", 1))
            .andExpect(status().isOk())
            .andExpect(content().string(""));
    }

    @Test
    public void listStudentsOk() throws Exception {

        Set<StudentDTO> expectedResponse = StudentUtils.createTestStudents();
        String expectedResponseJson = new ObjectMapper().writeValueAsString(expectedResponse);

        mockMvc
            .perform(get("/student/listStudents"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedResponseJson));
    }
}
