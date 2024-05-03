package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test") // Por si tienes perfiles para pruebas
public class ControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindCharacterByQuery() throws Exception {
        // Solicitud para buscar un personaje por parte del nombre
        mockMvc.perform(MockMvcRequestBuilders.get("/Luke")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1)) // Se espera un resultado
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    public void testFindCharacterByPartialQuery() throws Exception {
        // Solicitud para buscar personajes por una parte del nombre
        mockMvc.perform(MockMvcRequestBuilders.get("/Luk")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1)) // Se espera un resultado
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    public void testFindNoCharactersByQuery() throws Exception {
        // Solicitud para buscar un personaje que no existe
        mockMvc.perform(MockMvcRequestBuilders.get("/Nonexistent")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0)); // No se esperan resultados
    }
}
