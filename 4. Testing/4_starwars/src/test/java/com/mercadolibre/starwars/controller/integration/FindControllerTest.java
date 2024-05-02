package com.mercadolibre.starwars.controller.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.w3c.dom.stylesheets.MediaList;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    private static ObjectMapper writer;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        FindControllerTest.writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }


    @Test
    void findLuke() throws Exception {
        // arrange
        String query = "Luke";
        List<CharacterDTO> characters = List.of(
                new CharacterDTO(
                        "Luke Skywalker",
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        77,
                        172
                )
        );

        List<String> charactersStringList = characters.stream().map(c -> {
            try {
                return writer.writeValueAsString(c);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        // act
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/{character}", query))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // assert
        Assertions.assertEquals(charactersStringList.toString().length()
                , result.getResponse().getContentAsString().length());

    }

    @Test
    void findUnknownChatacter() throws Exception {
        // arrange
        String query = "Empanadas de carne";

        // act
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/{character}", query))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"))
                .andReturn();

        // assert
        Assertions.assertEquals("[]".length()
                , result.getResponse().getContentAsString().length());

    }
}