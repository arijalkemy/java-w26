package com.EjercicioSpring.Ejercicio3_NumerosRomanos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumbersImplTest {

    private RomanNumbersService romanNumbersService;

    @BeforeEach
    void setUp() {
        romanNumbersService = new RomanNumbersImpl();
    }

    @DisplayName("Test - Conversión exitosa de números")
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "3, III",
            "5, V",
            "7, VII",
            "10, X",
            "50, L"
    })
    void convertDecimalToRomanTest(int value, String expected) {
        // Act
        String result = romanNumbersService.convertDecimalToRoman(value);
        // Assertions
        assertEquals(expected, result);
    }
}