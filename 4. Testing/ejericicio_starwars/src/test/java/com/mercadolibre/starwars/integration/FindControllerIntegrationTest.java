package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter objectWriter;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void findTest() throws Exception {
        List<CharacterDTO> characterDTOList = new ArrayList<CharacterDTO>();
        characterDTOList.add(
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

        String expectedResponseJson = objectWriter.writeValueAsString(characterDTOList);

        MvcResult mvcResult = mockMvc
                .perform(
                    MockMvcRequestBuilders.get("/Luke")
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), expectedResponseJson);
    }

    @Test
    public void findWithoutResultsTest() throws Exception {
        List<CharacterDTO> characterDTOList = new ArrayList<CharacterDTO>();
        String expectedResponseJson = objectWriter.writeValueAsString(characterDTOList);

        MvcResult mvcResult = mockMvc
            .perform(
                    MockMvcRequestBuilders.get("/asdasd")
                            .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), expectedResponseJson);
    }
}
