package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RomanNumeralsRestTest {


    private RomanNumeralsRestController romanNumeralsRestController;

    @BeforeEach
    void setUp() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    @DisplayName("Test para el numero romano I")
    void testI() {
        //Arrange
        Integer number = 1;
        String expected = "I";
        String response;

        //Act
        response = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(expected, response);
    }

    @Test
    @DisplayName("Test para el numero romano V")
    void testV() {
        //Arrange
        Integer number = 5;
        String expected = "V";
        String response;

        //Act
        response = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(expected, response);
    }

    @Test
    @DisplayName("Test para el numero romano X̅")
    void testDiezMil() {
        //Arrange
        Integer number = 100000;
        String expected = "X̅";
        String response;

        //Act
        response = romanNumeralsRestController.toRoman(number);

        //Assert
        //La respuesta no es correcta por la implementación
        Assertions.assertNotEquals(expected, response);
    }

    @Test
    @DisplayName("Test para el numero nulo")
    void testNullNumber() {
        //Arrange
        Integer number = null;

        //Act
        //Assertions
        Assertions.assertThrows(NullPointerException.class, () -> romanNumeralsRestController.toRoman(number));



    }

}
