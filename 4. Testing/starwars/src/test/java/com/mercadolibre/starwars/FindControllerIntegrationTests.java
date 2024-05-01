package com.mercadolibre.starwars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findSingleCharacterByQuery() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Luke Skywalker")));
    }

    @Test
    public void findMultipleCharactersByQuery() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Darth Vader")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Darth Maul")));
    }

    @Test
    public void findNoCharactersWithQuery() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "512412312312123213123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("[]")));
    }
}
