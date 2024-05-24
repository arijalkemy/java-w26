package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class integrationTestObtenerDiploma {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentDAO studentRepository;


    private static ObjectWriter objWriter;

    SubjectDTO mathematics;
    SubjectDTO music;
    SubjectDTO physical;

    StudentDTO testStudent;


    @BeforeAll
    public static void initialize() {
        objWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void setup() {
        mathematics = new SubjectDTO("Mathematics", 5.0);
        music = new SubjectDTO("Music", 5.0);
        physical = new SubjectDTO("Physical", 5.0);

        testStudent = new StudentDTO(1L, "Juan","El alumno Juan ha obtenido un promedio de 5,00. Puedes mejorar.", 5.0, List.of(mathematics, music, physical) );

        if( ! studentRepository.exists( testStudent ) )
            studentRepository.save( testStudent );

    }

    @Test
    public void testAnalyzeScores() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1));
    }

}
