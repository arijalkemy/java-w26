package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    public void findTest() throws Exception {
        String query = "luke";

        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");

        List<CharacterDTO> listExpected = List.of(character);
        String responseExpected = mapper.writeValueAsString(listExpected);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andReturn();

        Assertions.assertEquals(responseExpected, result.getResponse().getContentAsString());
    }

    @Test
    public void notFoundTest() throws Exception {
        String query = "asdf";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals("[]", result.getResponse().getContentAsString());
    }

}
