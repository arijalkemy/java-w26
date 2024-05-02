package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralsControllerUnitTests {
    private RomanNumeralsRestController romanNumeralsRestController;

    @BeforeEach
    void setUp() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    public void oneShouldBeI(){
        String expected = "I";
        String obtained = romanNumeralsRestController.toRoman(1);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void threeShouldBeIII(){
        String expected = "III";
        String obtained = romanNumeralsRestController.toRoman(3);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void fiveShouldBeV(){
        String expected = "V";
        String obtained = romanNumeralsRestController.toRoman(5);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void sevenShouldBeVII(){
        String expected = "VII";
        String obtained = romanNumeralsRestController.toRoman(7);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void tenShouldBeX(){
        String expected = "X";
        String obtained = romanNumeralsRestController.toRoman(10);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void fiftyShouldBeL(){
        String expected = "L";
        String obtained = romanNumeralsRestController.toRoman(50);
        Assertions.assertEquals(expected, obtained);
    }
}
