package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest2 {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;
    ObjectWriter objectWriter;

    public StudentControllerIntegrationTest2() {
        objectWriter = new ObjectMapper()
                .configure(
                        SerializationFeature.WRAP_ROOT_VALUE,
                        false
                )
                .writer();
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("obtener usuario con id 1")
    public void getById() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/student/getStudent/1"))
                .andExpect(status().isOk())
                .andReturn();

        StudentDTO studentResponseDTO = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                StudentDTO.class
        );

        Assertions.assertEquals(
                studentResponseDTO.getId(),
                1L
        );
    }

    @Test
    @DisplayName("Guardar usuario 2")
    public void guardarUsuario2() throws Exception {
        SubjectDTO matematica = new SubjectDTO("Math", 10.0d);
        SubjectDTO science = new SubjectDTO("Science", 6.0d);

        StudentDTO studentDTO = new StudentDTO(
                2L,
                "Nacho",
                "Hola",
                6.0d,
                List.of(matematica,science)
        );

        MvcResult mvcResult = mockMvc
                .perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andReturn();
    }

}
