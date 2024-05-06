package com.mercadolibre.starwars.integration.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Return a character founded by name")
    void findOne() throws Exception {
        mockMvc.perform(get("/Luke"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name': 'Luke Skywalker'}]"));
    }

    @Test
    @DisplayName("Return a empty array")
    void notFind() throws Exception {
        mockMvc.perform(get("/Jack"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}