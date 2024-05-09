package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    private IStudentDAO studentDAO;
    private ObjectWriter objectWriter;


    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();
        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo =   new SubjectDTO("POO",    2.0);
        StudentDTO student = new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );
        studentDAO.save(student);

        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Endpoint should register a valid student")
    void registerStudent() throws Exception {
        StudentDTO payloadDTO = new StudentDTO(2L, "Agustin",
                "El alumno Agustin ha obtenido un promedio de 4,00. Puedes mejorar.",
                4.0,List.of(new SubjectDTO("Kahoot", 1.0),new SubjectDTO("System Design", 7.0)));

        String payloadJson = objectWriter.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getStudent() {
    }

    @Test
    void modifyStudent() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void listStudents() {
    }
}