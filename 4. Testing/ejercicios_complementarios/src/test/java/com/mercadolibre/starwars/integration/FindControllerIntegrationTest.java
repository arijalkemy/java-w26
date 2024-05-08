package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    }

    @Test
    public void findCharacterOkTest() throws Exception {
        // Arrange
        String name = "Luke";
        CharacterDTO character = new CharacterDTO(
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
        List<CharacterDTO> characterDTOs = new ArrayList<>(){{
            add(character);
        }};

        // Act
        MvcResult response = this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/{query}", name)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

        String result = response.getResponse().getContentAsString();

        // Assert
        Assertions.assertEquals(writer.writeValueAsString(characterDTOs), result);
    }

    @Test
    public void findNoOneOk() throws Exception {
        // Arrange
        String name = "Matches No One";
        List<CharacterDTO> characterDTOs = new ArrayList<>();

        // Act
        MvcResult response = this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/{query}", name)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

        String result = response.getResponse().getContentAsString();

        // Assert
        Assertions.assertEquals(writer.writeValueAsString(characterDTOs), result);
    }
}
