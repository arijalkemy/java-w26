package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.util.GenerateCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FindIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void testFindByLukeName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/Luke"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(List.of(GenerateCharacter.generateLuke()))));
    }

    @Test
    void testFindByEmptyName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testFindByNonExistentName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/asd"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testFindByDarthName() throws Exception {
        List<CharacterDTO> darthCharacters = new ArrayList<>(){
            {
                add(GenerateCharacter.generateDathVader());
                add(GenerateCharacter.generateDathMaul());
            }
        };

        this.mockMvc.perform(MockMvcRequestBuilders.get("/Darth"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(darthCharacters)));
    }
}
