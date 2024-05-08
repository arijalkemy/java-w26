package com.mercadolibre.starwars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Luke contains Luke Skywalker")
    void happyPathOne() throws Exception {
        this.performTestok("luke", "Luke Skywalker");
    }
    @Test
    @DisplayName("Darth contains Darth Vader")
    void happyPathTwo() throws Exception {
        this.performTestok("darth", "Darth Vader");
    }
    

    private void performTestok(String name, String expectedName) throws Exception{

        this.mockMvc.perform(get("/" + name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name", hasItem(equalTo(expectedName))));
    }

}
