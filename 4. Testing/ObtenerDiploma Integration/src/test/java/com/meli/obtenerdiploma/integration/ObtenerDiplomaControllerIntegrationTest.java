package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();
        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo =   new SubjectDTO("POO",    2.0);
        StudentDTO student = new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );
        studentDAO.save(student);
    }



    @Test
    @DisplayName("Endpoint GET should brings the correct user")
    void analyzeScores() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1L))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Anibal"));
    }
    @Test
    @DisplayName("Endpoint GET should throw a notFoundException if the user does not exist in the DB")
    void getAnalyzeScoreShouldThrowException() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",3L))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("Endpoint GET should throw badRequestException if the param is not a number")
    void getAnalyzeScoreShouldThrowBadRequestIfTheParamIsNotANumber() throws Exception {
       this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","A"))
               .andExpect(status().isBadRequest());
    }
}