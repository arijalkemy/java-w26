package com.mercadolibre.starwars.integrations;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void find() throws Exception {

         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Dark"))
                 .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(content().contentType("application/json"))
                 .andExpect(jsonPath("$.[*].name[*]", Matchers.everyItem(Matchers.containsString("Dark"))))
                 .andReturn();
    }
}
