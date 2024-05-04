package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @AfterAll
    public static void cleanUp() {
    }

    @Test
    @DisplayName("Crea un estudiante de manera correcta, con todos sus campos bien")
    public void createCorrectStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO(4L, "Pepito 4", "Mensaje", 10.0,
                List.of(new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Biologia", 9.0),
                        new SubjectDTO("Sociales", 8.0)));

        String json = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Crea un estudiante con el nombre nulo")
    public void createStudentWithNullName() throws Exception {
        StudentDTO studentDTO = new StudentDTO(4L, null, "Mensaje", 10.0,
                List.of(new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Biologia", 9.0),
                        new SubjectDTO("Sociales", 8.0)));

        String json = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    @DisplayName("devuelve la excepción HttpMessageNotReadableException del atributo score mal informado")
    public void createStudentBadAttributeInfoTest() throws Exception{
        String json = "{\"id\" : 4, \"studentName\" : \"Pepito 4\",\"message\" : \"Mensaje\",\"averageScore\" : 10.0,"
                + "\"subjects\" : [ {\"name\" : \"Matematicas\",\"score\" : \"10.0A\"} ]}";
        Integer id = 10;
        mockMvc.perform(post("/student/registerStudent", id))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name" ).value("HttpMessageNotReadableException"));
    }

    @Test
    @DisplayName("devuelve un Set de estudiantes")
    public void getSetOfStudents() throws Exception{
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("Pepito 2")));
    }
}
