package com.mercadolibre.starwars.controller.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class FindControllerTest {
    static List<CharacterDTO> characterDTOList = new ArrayList<>();

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @BeforeAll
    static void loadCharacters () {
        characterDTOList = TestUtils.readCharactersJSON();
    }

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Should return empty when there are  no matches")
    void shouldReturnEmptyNoMatches() throws Exception {
        String query = "random query text";
        String expectedResponse = writer.writeValueAsString(new ArrayList<>());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String actualResponse = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    @DisplayName("Should find one character")
    void shouldFindOneCharacter() throws Exception {
        assertResultByQuery("Luke", status().isOk(), content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Should find multiple characters")
    void shouldFindMultipleCharacters() throws Exception {
        assertResultByQuery("Darth", content().contentType(MediaType.APPLICATION_JSON), status().isOk());
    }

    @Test
    @DisplayName("Query should be case in-sensitive")
    void queryShouldBeCaseInSensitive() throws Exception {
        assertResultByQuery("luke", content().contentType(MediaType.APPLICATION_JSON), status().isOk());
    }

    @Test
    @DisplayName("Should accept special characters")
    void shouldAcceptSpecialCharacters() throws Exception {
        assertResultByQuery("Ki-Adi-Mundi", content().contentType(MediaType.APPLICATION_JSON), status().isOk());
    }

    private void assertResultByQuery(String Luke, ResultMatcher Ok, ResultMatcher APPLICATION_JSON) throws Exception {
        String query = Luke;
        List<CharacterDTO> expectedCharacters = characterDTOList.stream()
                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        String expectedResponse = writer.writeValueAsString(expectedCharacters);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(Ok)
                .andExpect(APPLICATION_JSON)
                .andReturn();
        String actualResponse = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals(expectedResponse, actualResponse);
    }

}
