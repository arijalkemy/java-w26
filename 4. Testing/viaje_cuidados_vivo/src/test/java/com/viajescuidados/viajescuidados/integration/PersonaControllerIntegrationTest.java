package com.viajescuidados.viajescuidados.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PersonaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Buscar persona NO existente")
    public void buscarPersonaNoExistenteTest() throws Exception {
        // ID de una persona que no existe en la base de datos
        int id = 100;

        // Realizar la solicitud GET al endpoint /personas/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/personas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()) // Imprimir detalles de la respuesta en la consola
                .andExpect(status().isNotFound()); // Verificar que el estado de la respuesta sea Not Found (404)
    }

    @Test
    @DisplayName("Buscar una persona existente")
    public void buscarPersonaExistenteTest() throws Exception {
        // ID de una persona existente en la base de datos
        int id = 1;

        // Realizar la solicitud GET al endpoint /personas/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/personas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()) // Imprimir detalles de la respuesta en la consola
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Verificar que el tipo de contenido sea JSON
                .andExpect(jsonPath("$.nombre").value("sadsa")) // Verificar que el nombre retornado sea "Juan"
                .andExpect(jsonPath("$.apellido").value("asd")); // Verificar que el apellido retornado sea "Perez"
    }


}
