package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestStudent {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentDAO studentDAO;

    private StudentDTO student;
    private SubjectDTO kahoot;
    private SubjectDTO musica;
    private SubjectDTO poo;

    @BeforeEach
    void setUp() {
        kahoot = new SubjectDTO("Kahoot", 9.0);
        musica = new SubjectDTO("Música", 8.0);
        poo = new SubjectDTO("POO", 10.0);

        student = new StudentDTO(1L, "John Doe", null, null, Arrays.asList(kahoot, musica, poo));
        studentDAO.save(student);
    }

    @Test
    void getStudentValidIdReturnsStudentDTO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", student.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$.subjects.length()").value(student.getSubjects().size()))
                .andExpect(jsonPath("$.message").doesNotExist());
    }

    @Test
    void registerStudentValidStudentDataReturnsCreatedStatus() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentValidStudentDataReturnsOkStatus() throws Exception {
        StudentDTO updated = new StudentDTO(1L, "John Doe", "null", null, Arrays.asList(kahoot, musica, poo));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updated)))
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentValidIdReturnsNoContentStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", student.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsReturnsListOfStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }
}