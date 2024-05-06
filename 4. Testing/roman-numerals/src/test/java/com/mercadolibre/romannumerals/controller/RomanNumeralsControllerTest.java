package com.mercadolibre.romannumerals.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void oneToRoman() throws Exception {
        testToRoman(1, "I");
    }

    @Test
    void fiveToRoman() throws Exception {
        testToRoman(5, "V");
    }

    @Test
    void tenToRoman() throws Exception {
        testToRoman(10, "X");
    }

    @Test
    void fiftyToRoman() throws Exception {
        testToRoman(50, "L");
    }

    @Test
    void hundredToRoman() throws Exception {
        testToRoman(100, "C");
    }

    @Test
    void thousandToRoman() throws Exception {
        testToRoman(1000, "M");
    }

    @Test
    void seventeenToRoman() throws Exception {
        testToRoman(17, "XVII");
    }

    @Test
    void fourteenEightyFiveToRoman() throws Exception {
        testToRoman(1485, "MCDLXXXV");
    }

    private void testToRoman(Integer number, String expected) throws Exception {
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expected));
    }
}
