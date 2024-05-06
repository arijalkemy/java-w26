package com.mercadolibre.starwars.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void searchOneCharacter() throws Exception {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setGender("male");
        characterDTO.setSpecies("Human");
        characterDTO.setEye_color("blue");
        characterDTO.setHair_color("blond");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setSkin_color("fair");

        List<CharacterDTO> characterDTOList = List.of(characterDTO);

        MvcResult results = this.mockMvc.perform(
                                     MockMvcRequestBuilders.get("/Luke"))
                                    .andDo(print())
                                    .andExpect(status().isOk())
                                    .andReturn();

        String jsonResponse = results.getResponse().getContentAsString();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        Assertions.assertTrue(StreamSupport.stream(rootNode.spliterator(), false)
                .anyMatch(elemento -> elemento.get("name").asText().contains("Luke")));
    }
}
