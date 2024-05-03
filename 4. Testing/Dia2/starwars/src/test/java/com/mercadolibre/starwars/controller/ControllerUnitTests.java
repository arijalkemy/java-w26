package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(FindController.class)
public class ControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    @Test
    public void testFindCharactersByQuery() throws Exception {
        // Configurar datos para el mock
        List<CharacterDTO> mockResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "Blond", "Fair", "Blue", "19BBY", "Male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Leia Organa", "Brown", "Light", "Brown", "19BBY", "Female", "Alderaan", "Human", 150, 49)
        );

        // Mockear la respuesta del servicio
        when(findService.find(anyString())).thenReturn(mockResult);

        // Hacer la solicitud y validar el resultado
        mockMvc.perform(MockMvcRequestBuilders.get("/Luke"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2)) // Espera 2 resultados
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Leia Organa"));
    }

    @Test
    public void testFindCharactersNotFound() throws Exception {
        // Mockear una respuesta vacía
        when(findService.find(anyString())).thenReturn(List.of());

        // Hacer la solicitud y validar el resultado
        mockMvc.perform(MockMvcRequestBuilders.get("/Nonexistent"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0)); // Sin resultados
    }
}
