package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNumeralNumberAndGet200StatusTest() throws Exception {
        mockMvc.perform(get("/{number}", 10))
                .andDo(print())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    @Test
    public void getBadRequest400StatusTest() throws Exception {
        mockMvc.perform(get("/{number}", "10A"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
