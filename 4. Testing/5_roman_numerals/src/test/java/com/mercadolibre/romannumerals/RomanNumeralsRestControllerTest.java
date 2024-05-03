package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController romanNumeralsRestController;

    @BeforeEach
    void setUp() {
        this.romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    void goodDecimalToRoman() {
        // Arrange
        String expected = "III";
        // act
        String result = this.romanNumeralsRestController.toRoman(3);
        // assert
        assertEquals(expected, result);
    }

    @Test
    void zeroDecimalToRoman() {
        // Arrange
        String expected = "";
        // act
        String result = this.romanNumeralsRestController.toRoman(0);
        // assert
        assertEquals(expected, result);
    }

    @Test
    void maxDecimalToRoman() {
        // Arrange
        String expected = "MMMCMXCIX";
        // act
        String result = this.romanNumeralsRestController.toRoman(3999);
        // assert
        assertEquals(expected, result);
    }
}