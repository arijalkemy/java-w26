package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsRestControllerTest {

    @Autowired
    private RomanNumeralsRestController romanNumeralsRestController;

    @Test
    public void toRomanNumberOneTest() {
        testExecution(1, "I");
    }

    @Test
    public void toRomanNumberThreeTest() {
        testExecution(3, "III");
    }

    @Test
    public void toRomanNumberFiveTest() {
        testExecution(5, "V");
    }

    @Test
    public void toRomanNumberSevenTest() {
        testExecution(7, "VII");
    }

    @Test
    public void toRomanNumberTenTest() {
        testExecution(10, "X");
    }

    @Test
    public void toRomanNumberFiftyTest() {
        testExecution(50, "L");
    }

    private void testExecution(int toConvert, String expectedResult) {
        // Act
        String result = romanNumeralsRestController.toRoman(toConvert);

        // Assert
        assertEquals(result, expectedResult);
    }
}
