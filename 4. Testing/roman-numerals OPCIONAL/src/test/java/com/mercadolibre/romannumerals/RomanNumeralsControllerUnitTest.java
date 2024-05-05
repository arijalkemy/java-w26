package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RomanNumeralsControllerUnitTest {

    private RomanNumeralsRestController controller;

    @BeforeEach
    void setUp() {
        controller = new RomanNumeralsRestController();
    }

    @Test
    @DisplayName("Obtiene el número 1 en Romano")
    public void getOneInRomanTest() {
        //Arrange
        String expected = "I";
        Integer numberToTransform = 1;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 3 en Romano")
    public void getThreeInRomanTest() {
        //Arrange
        String expected = "III";
        Integer numberToTransform = 3;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 4 en Romano")
    public void getFourInRomanTest() {
        //Arrange
        String expected = "IV";
        Integer numberToTransform = 4;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 5 en Romano")
    public void getFiveInRomanTest() {
        //Arrange
        String expected = "V";
        Integer numberToTransform = 5;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 7 en Romano")
    public void getSevenInRomanTest() {
        //Arrange
        String expected = "VII";
        Integer numberToTransform = 7;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 10 en Romano")
    public void getTenInRomanTest() {
        //Arrange
        String expected = "X";
        Integer numberToTransform = 10;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 50 en Romano")
        public void getFiftyInRomanTest() {
        //Arrange
        String expected = "L";
        Integer numberToTransform = 50;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 100 en Romano")
    public void getOneHundredInRomanTest() {
        //Arrange
        String expected = "C";
        Integer numberToTransform = 100;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 1000 en Romano")
    public void getOneThousandInRomanTest() {
        //Arrange
        String expected = "M";
        Integer numberToTransform = 1000;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Obtiene el número 4000 en Romano (CASO BORDE)")
    public void getBorderFourThousandRomanNumeralTest() {
        //Arrange
        String expected = "MMMM";
        Integer numberToTransform = 4000;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertTrue(output.contains(expected));
    }

    @Test
    @DisplayName("Obtiene el número 4950 en Romano (CASO BORDE)")
    public void getGreaterThanFourThousandRomanNumeralTest() {
        //Arrange
        String expected = "MMMM";
        Integer numberToTransform = 4950;

        //Act
        String output = controller.toRoman(numberToTransform);

        //Assert
        Assertions.assertTrue(output.contains(expected));
    }
}
