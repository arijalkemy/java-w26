package org.example.integradorromanos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ConversorServiceImpTest {

    public IConversorService conversorService;

    @BeforeEach
    public void setup(){
        this.conversorService = new ConversorServiceImp();
    }

    @Test
    @DisplayName("Debería devolver ''")
    public void convertToRomanBelow20(){
        //Arrange
        int decimal1 = 19;
        int decimal2 = 9;
        int decimal3 = 14;

        String expected1 = "XIX";
        String expected2 = "IX";
        String expected3 = "XIV";

        //Act
        String result1 = conversorService.convertToRoman(decimal1);
        String result2 = conversorService.convertToRoman(decimal2);
        String result3 = conversorService.convertToRoman(decimal3);

        //Assert
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Debería devolver ''")
    public void convertToRomanBelow50(){
        //Arrange
        int decimal1 = 41;
        int decimal2 = 49;
        int decimal3 = 39;

        String expected1 = "XLI";
        String expected2 = "XLIX";
        String expected3 = "XXXIX";

        //Act
        String result1 = conversorService.convertToRoman(decimal1);
        String result2 = conversorService.convertToRoman(decimal2);
        String result3 = conversorService.convertToRoman(decimal3);

        //Assert
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Debería devolver ''")
    public void convertToRomanBelow100(){
        //Arrange
        int decimal1 = 67;
        int decimal2 = 94;
        int decimal3 = 87;

        String expected1 = "LXVII";
        String expected2 = "XCIV";
        String expected3 = "LXXXVII";

        //Act
        String result1 = conversorService.convertToRoman(decimal1);
        String result2 = conversorService.convertToRoman(decimal2);
        String result3 = conversorService.convertToRoman(decimal3);

        //Assert
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Debería devolver ''")
    public void convertToRomanBelow500(){
        //Arrange
        int decimal1 = 333;
        int decimal2 = 495;
        int decimal3 = 231;

        String expected1 = "CCCXXXIII";
        String expected2 = "CDXCV";
        String expected3 = "CCXXXI";

        //Act
        String result1 = conversorService.convertToRoman(decimal1);
        String result2 = conversorService.convertToRoman(decimal2);
        String result3 = conversorService.convertToRoman(decimal3);

        //Assert
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Debería devolver ''")
    public void convertToRomanBelow1000(){
        //Arrange
        int decimal1 = 614;
        int decimal2 = 999;
        int decimal3 = 734;

        String expected1 = "DCXIV";
        String expected2 = "CMXCIX";
        String expected3 = "DCCXXXIV";

        //Act
        String result1 = conversorService.convertToRoman(decimal1);
        String result2 = conversorService.convertToRoman(decimal2);
        String result3 = conversorService.convertToRoman(decimal3);

        //Assert
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

}