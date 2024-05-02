package com.mercadolibre.starwars.unitTest.controllers;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
    void findCharactersWithAntName() throws Exception {
        List<CharacterDTO> charactersAnt = new ArrayList<>();

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Wedge Antilles");
        character1.setHeight(170);
        character1.setMass(77);
        character1.setHair_color("brown");
        character1.setSkin_color("fair");
        character1.setEye_color("hazel");
        character1.setBirth_year("21BBY");
        character1.setGender("male");
        character1.setHomeworld("Corellia");
        character1.setSpecies("Human");

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Raymus Antilles");
        character2.setHeight(188);
        character2.setMass(79);
        character2.setHair_color("brown");
        character2.setSkin_color("light");
        character2.setEye_color("brown");
        character2.setBirth_year("NA");
        character2.setGender("male");
        character2.setHomeworld("Alderaan");
        character2.setSpecies("Human");

        charactersAnt.add(character1);
        charactersAnt.add(character2);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Ant"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Wedge Antilles"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].eye_color").value("hazel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value("Raymus Antilles"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].eye_color").value("brown"))
                .andReturn();

        String resultResponse = result.getResponse().getContentAsString();

        String expectedResponse = writer.writeValueAsString(charactersAnt);

        Assertions.assertEquals(expectedResponse, resultResponse);
        Assertions.assertTrue(resultResponse.contains("Raymus Antilles"));
    }
}
