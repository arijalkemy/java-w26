package com.mercadolibre.starwars.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     *  Test for the controller to query a character by name
     */
    @Test
    public void testGetCharacter() throws Exception {
        // arrange
        String query = "Luke Skywalker";
        CharacterDTO characterDTO = fillCharacterDTO();
        List<CharacterDTO> characterDTOList = List.of(characterDTO);
        // act && assert

        ObjectMapper objectMapper = new ObjectMapper();
        String characterDTOJson = objectMapper.writeValueAsString(characterDTOList);

        mockMvc.perform(get("/{query}" , query)).andExpect(status().isOk())
                .andExpect(content().json(characterDTOJson));
        // assert
    }

    private CharacterDTO fillCharacterDTO() {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        characterDTO.setGender("male");
        return characterDTO;
    }

}
