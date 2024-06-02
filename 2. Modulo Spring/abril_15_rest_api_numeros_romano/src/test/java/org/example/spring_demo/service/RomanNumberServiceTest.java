package org.example.spring_demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanNumberServiceTest {

    @Autowired
    RomanNumberService romanNumberService;

    @Test
    void testGetRomanNumber() {
        String romanNumber = romanNumberService.getRomanNumber("1");
        assertEquals("I", romanNumber);
    }

    @Test
    void checkAMiddleRomanNumber() {
        String romanNumber = romanNumberService.getRomanNumber("2233");
        assertEquals("MMCCXXXIII", romanNumber);
    }


    @Test
    void checkLastPossibleRomanNumber() {
        String romanNumber = romanNumberService.getRomanNumber("3999");
        assertEquals("MMMCMXCIX", romanNumber);
    }
}
