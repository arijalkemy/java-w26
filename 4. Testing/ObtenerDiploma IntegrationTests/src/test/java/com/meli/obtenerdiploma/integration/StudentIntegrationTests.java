package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter ow;

    @BeforeAll
    public static void init() {
        ow = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void givenNoName_whenPostStudent_thenShouldReturnBadRequest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        studentDTO.setStudentName(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    public void givenNoContent_whenPostStudent_thenShouldReturnBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
