package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(null, "Test student 1", null,
                null, List.of(new SubjectDTO("Math", 8.0),
                new SubjectDTO("Science", 9.0)));
    }

    @Test
    @DisplayName("Should register a student")
    void registerStudent() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payLoadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(header().doesNotExist("Content-Type"));
    }

    @Test
    @DisplayName("Should return 400 when trying to register a student with invalid data")
    public void registerStudent_badRequest() throws Exception {

        studentDTO.setStudentName(null);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();

        String json = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.name")
                        .value("MethodArgumentNotValidException"));
    }

    @Test
    @DisplayName("Should return a student")
    void getStudent() throws Exception {
        mockMvc.perform(get("/student/getStudent/{studentId}", 47L))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Test student 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("Math"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].score").value(8.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[1].name").value("Science"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[1].score").value(9.0))
                .andReturn();
    }

    @Test
    void modifyStudent() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();

        String json = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(header().doesNotExist("Content-Type"));
    }

    @Test
    @DisplayName("Should remove a student")
    void removeStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{studentId}", 47L))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(header().doesNotExist("Content-Type"));
    }

    @Test
    @DisplayName("Should return a list of students")
    void listStudents() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andReturn();
    }
}