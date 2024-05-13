package com.w26.romanos.unit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.w26.romanos.components.RomanConversorComponent;
import com.w26.romanos.exception.ConversionException;
import com.w26.romanos.repository.RomanConversionMapRepository;


@ExtendWith(MockitoExtension.class)
public class RomanConversorComponentTest {


    @Spy
    RomanConversionMapRepository repositoryMock;    

    @InjectMocks
    private RomanConversorComponent systemUnderTest;

    @Test
    @DisplayName("Test for verify propertie subtraction in conversion of decimal number to roman number")
    public void substractionPropertieTest() {
        //Arrange
        List<Integer> inputs = List.of(4, 9, 49, 90); 
        List<String> expected = List.of("IV", "IX", "XLIX",  "XC");

        //Act and Assertions
        for (int i = 0; i < inputs.size(); i++) {
            String result = systemUnderTest.integerToRoman(inputs.get(i));
            Assertions.assertEquals(expected.get(i), result);
        }    
    }


    @Test
    @DisplayName("Test for verify propertie addition in conversion of decimal number to roman number")
    public void additionPropertieTest() {
        //Arrange
        List<Integer> inputs = List.of(8, 13, 2021, 300); 
        List<String> expected = List.of("VIII", "XIII", "MMXXI",  "CCC");

        //Act and Assertions
        for (int i = 0; i < inputs.size(); i++) {
            String result = systemUnderTest.integerToRoman(inputs.get(i));
            Assertions.assertEquals(expected.get(i), result);
        }    
    }

    @Test
    @DisplayName("Test to verify range or limit where component raise exception")
    public void getExceptionToMakeConversionOutLimit() {
        //Arrange
        Integer input = -1;
        //Act and Assertions
        Assertions.assertThrows(ConversionException.class, () -> systemUnderTest.integerToRoman(input));
    }


    
}
