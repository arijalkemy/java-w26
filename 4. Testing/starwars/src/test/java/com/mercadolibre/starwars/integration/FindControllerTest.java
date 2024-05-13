package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Found All by name contains successful in test integration")
    void testFindAllByNameOk() throws Exception {
        // arrange
        String request = "luke";

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/{request}", request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name")
                        .value("Luke Skywalker"));
    }

    @Test
    @DisplayName("Found All by name contains unsuccessful in test integration")
    void testFindAllByNameUnsuccessful() throws Exception {
        String request = "person_not_found";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/{request}", request))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        List<Object> jsonList = new ObjectMapper().readValue(jsonResponse,
                new TypeReference<List<Object>>() {});
        assertEquals(0, jsonList.size());
    }

}
