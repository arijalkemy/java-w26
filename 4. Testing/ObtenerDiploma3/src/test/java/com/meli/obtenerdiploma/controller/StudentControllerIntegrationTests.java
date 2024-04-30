package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerNewValidStudent() throws Exception {
        StudentDTO studentPayload = new StudentDTO();
        studentPayload.setStudentName("Pepe");
        studentPayload.setSubjects(List.of(new SubjectDTO("Física", 10.0)));

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = objectWriter.writeValueAsString(studentPayload);

        mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void registerNewInvalidStudentSubjects() throws Exception {
        StudentDTO studentPayload = new StudentDTO();
        studentPayload.setStudentName("Pepe");

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = objectWriter.writeValueAsString(studentPayload);

        mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                        .value(MethodArgumentNotValidException.class.getSimpleName()));
    }

    @Test
    public void registerNewInvalidStudentName() throws Exception {
        StudentDTO studentPayload = new StudentDTO();
        studentPayload.setStudentName("pepe");
        studentPayload.setSubjects(List.of(new SubjectDTO("Física", 10.0)));

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = objectWriter.writeValueAsString(studentPayload);

        mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                        .value(MethodArgumentNotValidException.class.getSimpleName()));
    }

    @Test
    public void getStudentSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"));
    }

    @Test
    public void getStudentUnsuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 800L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 800 no se encuetra registrado."));
    }

    @Test
    public void modifyStudentSuccessful() throws Exception {
        StudentDTO studentPayload = new StudentDTO();
        studentPayload.setId(1L);
        studentPayload.setStudentName("Juana");
        studentPayload.setSubjects(List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = objectWriter.writeValueAsString(studentPayload);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType("application/json")
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudentSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 5L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudentUnsuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 8L))
                .andDo(print())
                .andExpect(status().isOk());
        //It is unsuccessful inside the method, not in response
    }

    @Test
    public void getAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
