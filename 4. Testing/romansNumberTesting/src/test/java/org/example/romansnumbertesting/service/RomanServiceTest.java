package org.example.romansnumbertesting.service;

import org.example.romansnumbertesting.dto.RomanDto;
import org.example.romansnumbertesting.service.impl.RomanServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RomanServiceTest {
    private RomanServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new RomanServiceImpl();
    }

    @Test
    @DisplayName("convert number to roman: 7")
    public void convertIntegerToRoman7() {
        convertIntegerToRoman("VII", 7);

    }

    @Test
    @DisplayName("convert number to roman: 10")
    public void convertIntegerToRoman10() {
        convertIntegerToRoman("X", 10);

    }

    @Test
    @DisplayName("convert number to roman: 97")
    public void convertIntegerToRoman97() {
        convertIntegerToRoman("XCVII", 97);

    }

    @Test
    @DisplayName("convert number to roman: 50")
    public void convertIntegerToRoman50() {
        convertIntegerToRoman("L", 50);
    }

    private void convertIntegerToRoman(String expected, Integer number) {
        // act
        RomanDto actual = service.encodeRomanNumber(number);
        // assert
        Assertions.assertEquals(expected, actual.getRoman());
    }
}
