package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    static RomanNumeralsRestController romanNumeralsRestController;

    @BeforeAll
    static void setUp() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    void conversionCaseTest() {
        String response = romanNumeralsRestController.toRoman(1000);

        assertEquals(response, "M");
    }

    @Test
    void restaCaseTest() {
        String response = romanNumeralsRestController.toRoman(900);

        assertEquals(response, "CM");
    }

    @Test
    void simpleSumaCaseTest() {
        String response = romanNumeralsRestController.toRoman(1500);

        assertEquals(response, "MD");
    }

    @Test
    void multipleSumaCaseTest() {
        String response = romanNumeralsRestController.toRoman(1580);

        assertEquals(response, "MDLXXX");
    }

    @Test
    void invalidNumberCaseTest() {
        String response = romanNumeralsRestController.toRoman(0);

        assertEquals(response, "");
    }

}