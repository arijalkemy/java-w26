package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FindControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private String query;
    private CharacterDTO character;
    private List<CharacterDTO> characters;
    ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        query = "Luke";
        character = new CharacterDTO(
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
        );
        characters = List.of(character);

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void testFind() throws Exception {
        String responseJSON = writer.writeValueAsString(characters);

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJSON));
    }

    @Test
    public void testFindWithNoFoundName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "NoFoundName"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

}
