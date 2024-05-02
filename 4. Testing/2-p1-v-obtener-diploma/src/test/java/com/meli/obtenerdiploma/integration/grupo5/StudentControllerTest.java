package com.meli.obtenerdiploma.integration.grupo5;

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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    SubjectDTO subjectDTO;
    StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        subjectDTO = new SubjectDTO("Matematica", 10.0);
        studentDTO = new StudentDTO(99L,
                "Juan",
                "Perez",
                6.0,
                new ArrayList<>(List.of(subjectDTO)));
    }

    @Test
    public void registerStudentOkTest() throws Exception {

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
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("99"));
    }

    @Test
    @DisplayName("Should return 400 when trying to register a student with invalid data")
    public void registerStudentBadRequestTest() throws Exception {

        subjectDTO.setName("matematica");

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
    public void getStudent_ok() throws Exception {
        // Arrange
        Long studentId = 1L;
        // Act & Assert
        mockMvc
                .perform(get("/student/getStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(studentId))
                .andReturn();
    }

    @Test
    public void getStudent_notFound() throws Exception {
        // Arrange
        Long studentId = 999L;
        // Act & Assert
        mockMvc
                .perform(get("/student/getStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }


    @Test
    public void modifyStudent_ok() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();

        String json = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void modifyStudent_notFound() throws Exception {

        studentDTO.setId(998L);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();

        String json = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}