package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindTest {

    @Autowired
    private MockMvc mockMvc;

    //TODO: faltaria sumarle mas matcheos a los test

    @Test
    void findValidQueryTest() throws Exception {
        this.mockMvc.perform(get("/Luke"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void notFindQueryTest() throws Exception {
        this.mockMvc.perform(get("/Roberto"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void findInvalidQueryTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }
}
