package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RomanNumeralsRestController.class)
public class ControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRomanNumeralConversion() throws Exception {
        // 1 debería devolver I
        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("I"));
    }

    @Test
    public void threeIsIIITest() throws Exception {
        // 3 debería devolver III
        mockMvc.perform(get("/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("III"));
    }

    @Test
    public void fiveIsVTest() throws Exception {
        // 5 debería devolver V
        mockMvc.perform(get("/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("V"));
    }

    @Test
    public void sevenIsVIITest() throws Exception {
        // 7 debería devolver VII
        mockMvc.perform(get("/7"))
                .andExpect(status().isOk())
                .andExpect(content().string("VII"));
    }

    @Test
    public void tenIsXTest() throws Exception {
        // 10 debería devolver X
        mockMvc.perform(get("/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    @Test
    public void fiftyIsLTest() throws Exception {
        // 50 debería devolver L
        mockMvc.perform(get("/50"))
                .andExpect(status().isOk())
                .andExpect(content().string("L"));
    }
}
