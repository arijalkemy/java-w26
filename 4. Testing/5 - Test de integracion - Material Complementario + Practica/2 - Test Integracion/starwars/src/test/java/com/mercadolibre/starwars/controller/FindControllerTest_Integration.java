package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.Contains;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FindControllerTest_Integration {
    @MockBean
    FindService findService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("it should return one item about Luke SkyWalker")
    public void findOneCharacterTest() throws Exception{
        String query = "Luke";
        List<CharacterDTO> expectedCharacters = Arrays.asList(
                new CharacterDTO(
                        "Luke Skywalker",
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        172,
                        77
                )
        );
        when(findService.find(query)).thenReturn(expectedCharacters);

        ResultActions result = mockMvc.perform(
                get("/{query}", query)
                .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(jsonPath("$[*].name").value(expectedCharacters.get(0).getName()))
                .andExpect(jsonPath("$[*].name").value(expectedCharacters.get(0).getName()))
                .andExpect(jsonPath("$[*].hair_color").value(expectedCharacters.get(0).getHair_color()))
                .andExpect(jsonPath("$[*].skin_color").value(expectedCharacters.get(0).getSkin_color()))
                .andExpect(jsonPath("$[*].eye_color").value(expectedCharacters.get(0).getEye_color()))
                .andExpect(jsonPath("$[*].birth_year").value(expectedCharacters.get(0).getBirth_year()))
                .andExpect(jsonPath("$[*].gender").value(expectedCharacters.get(0).getGender()))
                .andExpect(jsonPath("$[*].homeworld").value(expectedCharacters.get(0).getHomeworld()))
                .andExpect(jsonPath("$[*].species").value(expectedCharacters.get(0).getSpecies()))
                .andExpect(jsonPath("$[*].height").value(expectedCharacters.get(0).getHeight()))
                .andExpect(jsonPath("$[*].mass").value(expectedCharacters.get(0).getMass()));
    }

    @Test
    @DisplayName("it should return two items about Darth Vader and Darth Maul")
    public void findTwoCharacterTest() throws Exception {
        String query = "Darth";
        List<CharacterDTO> expectedCharacters = Arrays.asList(
                new CharacterDTO(
                        "Darth Vader",
                        "none",
                        "white",
                        "yellow",
                        "41.9BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        202,
                        136
                ),
                new CharacterDTO(
                        "Darth Maul",
                        "none",
                        "red",
                        "yellow",
                        "54BBY",
                        "male",
                        "Dathomir",
                        "Zabrak",
                        175,
                        80
                )
        );

        when(findService.find(query)).thenReturn(expectedCharacters);
        ResultActions result = mockMvc.perform(
                get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*].name", hasItems("Darth Vader", "Darth Maul")));
    }


    @Test
    @DisplayName("it should return an empty list")
    public void findAll() throws Exception{
        String query = "empty";
        when(findService.find(query)).thenReturn(Collections.emptyList());

        ResultActions result = mockMvc.perform(
                get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$").isEmpty());
    }
}
