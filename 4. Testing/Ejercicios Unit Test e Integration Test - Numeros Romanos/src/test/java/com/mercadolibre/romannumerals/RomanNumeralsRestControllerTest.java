package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Devuelve el equivalente en número romano: I")
    public void testOneToRoman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/1"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("I"));
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: III")
    public void testTreeToRoman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("III"));
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: V")
    public void testFiveToRoman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/5"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("V"));
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: VII")
    public void testSevenToRoman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/7"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("VII"));
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: X")
    public void testTenToRoman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("X"));
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: L")
    public void testFiftyToRoman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/50"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("L"));
    }
}
