package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Se intenta crear alumno con datos incorrectos y lanza excepcion")
    public void resgisterStudentThrowsValidationException() throws Exception {
        StudentDTO studentWithInvalidArguments = new StudentDTO(
                2L,
                "Alumno Erroneo",
                "",
                0.0,
                List.of()
        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        ErrorDTO responseErrorDTO = new ErrorDTO(
                "MethodArgumentNotValidException",
                "La lista de materias no puede estar vacía."
        );

        String payloadJson = writer.writeValueAsString(studentWithInvalidArguments);
        String responseJson = writer.writeValueAsString(responseErrorDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andReturn();
    }
}
