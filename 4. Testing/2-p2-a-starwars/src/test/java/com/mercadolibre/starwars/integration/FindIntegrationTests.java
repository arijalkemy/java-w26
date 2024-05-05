package com.mercadolibre.starwars.integration;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    private CharacterDTO createCharacter(String name, String hairColor) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(name);
        characterDTO.setHair_color(hairColor);
        return characterDTO;
    }

    @Test
    public void findCharacterOkTest() throws Exception {
        // Given
        String query = "Skywalker";
        List<CharacterDTO> characters = Arrays.asList(
                createCharacter("Luke Skywalker", "blond"),
                createCharacter("Anakin Skywalker", "brown"),
                createCharacter("Shmi Skywalker", "brown")
        );

        when(findService.find(anyString())).thenReturn(characters);

        // When & Then
        mockMvc.perform(get("/" + query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(jsonPath("$[1].name").value("Anakin Skywalker"))
                .andExpect(jsonPath("$[2].name").value("Shmi Skywalker"));
    }


    @Test
    public void findCharacterNotFoundTest() throws Exception {
        // Given
        String query = "Andy";
        when(findService.find(anyString())).thenReturn(Collections.emptyList());

        // When & Then
        mockMvc.perform(get("/" + query))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }



}
