package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private CharacterDTO characterDTO;
    private List<CharacterDTO> characters;

    private static ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        characterDTO = new CharacterDTO();
        characterDTO.setName("Leia Organa");
        characterDTO.setHeight(150);
        characterDTO.setMass(49);
        characterDTO.setHair_color("brown");
        characterDTO.setSkin_color("light");
        characterDTO.setEye_color("brown");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("female");
        characterDTO.setHomeworld("Alderaan");
        characterDTO.setSpecies("Human");

        characters = List.of(characterDTO);

        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Deberia devolver una lista de CharacterDTO con en personaje de Leia Organa")
    void findCharactersTest() throws Exception {
        //act
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get("/{query}/", characterDTO.getName()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                ;
        //assert
        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(characters);

        Assertions.assertEquals(expectedString, resultString);

    }

    @Test
    @DisplayName("Deberia devolver una lista de caracteres vacia")
    void EmptyCharactersTest() throws Exception {
        //act
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get("/{query}/","Leiaa"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                ;
        //assert
        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(List.of());

        Assertions.assertEquals(expectedString, resultString);

    }
}
