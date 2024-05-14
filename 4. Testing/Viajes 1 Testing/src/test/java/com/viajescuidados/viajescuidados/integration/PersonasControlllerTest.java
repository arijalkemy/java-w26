package com.viajescuidados.viajescuidados.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.JsonPath;
import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.entities.Persona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonasControlllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        writer = objectMapper.writer();
    }

    @Test
    @DisplayName("Test para crear una persona")
    public void crearPersonaTest() throws Exception {
        // Arrange
        PersonaDTO personaToSave = new PersonaDTO("Mara", "Lopez");
        PersonaResponseDTO expectedPersona = new PersonaResponseDTO(1, "Mara", "Lopez");
        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/personas")
                .contentType("application/json")
                .content(writer.writeValueAsString(personaToSave)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Mara"))
                .andExpect(jsonPath("$.apellido").value("Lopez"));

    }

    @Test
    @DisplayName("Test para buscar una persona por id")
    public void buscarPersonaPorIdTest() throws Exception {
        // Arrange
        PersonaDTO personaToSave = new PersonaDTO("Mara", "Lopez");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/personas")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(personaToSave)))
                .andExpect(status().isOk());
        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/personas/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Mara"))
                .andExpect(jsonPath("$.apellido").value("Lopez"));
    }
}
