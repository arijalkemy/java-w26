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

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    SubjectDTO kahoot;
    SubjectDTO musica;
    SubjectDTO poo;

    StudentDTO student;


    private static ObjectWriter objWriter;

    SubjectDTO algebra;
    SubjectDTO art;
    SubjectDTO computerScience;

    StudentDTO pupil;


    @BeforeAll
    public static void initialize() {
        objWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void prepare() {
        algebra = new SubjectDTO("Algebra", 1.0);
        art = new SubjectDTO("Art", 9.0);
        computerScience = new SubjectDTO("Computer Science", 2.0);

        pupil = new StudentDTO(1L, "John","El alumno John ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(algebra, art, computerScience) );

        if( ! studentRepository.exists( pupil ) )
            studentRepository.save( pupil );

    }

    @Test
    public void testAnalyzeScores() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1));
    }

}
