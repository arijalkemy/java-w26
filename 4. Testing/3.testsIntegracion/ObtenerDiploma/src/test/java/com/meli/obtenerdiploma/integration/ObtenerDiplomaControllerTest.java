package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentDAO studentDAO;

    SubjectDTO Maths;
    SubjectDTO English;
    SubjectDTO French;

    StudentDTO student;

    @BeforeEach
    void setUp() {
        Maths = new SubjectDTO("Maths", 8.0);
        English = new SubjectDTO("English", 8.0);
        French = new SubjectDTO("French", 8.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(English);
        subjects.add(French);
        subjects.add(Maths);

        student = new StudentDTO(1L,"Pedro","message", 8.0, subjects);
        studentDAO.save(student);
    }

    @Test
    public void obtenerDiplomaTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andExpect(jsonPath("$.studentName").value("Pedro"))
                .andExpect(jsonPath("$.averageScore").value(8.0))
                .andExpect(jsonPath("$.subjects.length()").value(3)
                );
    }

    @Test
    public void obtenerDiplomaEstudianteNoEncontradoTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 87))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }

}
