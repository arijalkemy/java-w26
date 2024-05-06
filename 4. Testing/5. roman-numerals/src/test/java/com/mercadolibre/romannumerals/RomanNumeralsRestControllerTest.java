package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    static RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();

    @BeforeAll
    static void setUp() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    @DisplayName("Return I when input is 1")
    void toRomanI() {
        assertEquals("I", romanNumeralsRestController.toRoman(1));
    }

    @Test
    @DisplayName("Return III when input is 3")
    void toRomanIII() {
        assertEquals("III", romanNumeralsRestController.toRoman(3));
    }

    @Test
    @DisplayName("Return V when input is 5")
    void toRomanV() {
        assertEquals("V", romanNumeralsRestController.toRoman(5));
    }

    @Test
    @DisplayName("Return VII when input is 7")
    void toRomanVII() {
        assertEquals("VII", romanNumeralsRestController.toRoman(7));
    }

    @Test
    @DisplayName("Return X when input is 10")
    void toRomanX() {
        assertEquals("X", romanNumeralsRestController.toRoman(10));
    }

    @Test
    @DisplayName("Return L when input is 50")
    void toRomanL() {
        assertEquals("L", romanNumeralsRestController.toRoman(50));
    }

}