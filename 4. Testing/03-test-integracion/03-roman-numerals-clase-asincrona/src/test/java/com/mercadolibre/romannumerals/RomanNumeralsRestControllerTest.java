package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsRestControllerTest {

    @InjectMocks
    RomanNumeralsRestController romanNumeralsRestController;

    @Test
    @DisplayName("Convertir numero a romano")
    void toRoman(){
        int[] input = {1, 3, 5, 7, 10, 50};
        String[] expected = {"I", "III", "V", "VII", "X", "L"};

        for (int i = 0; i < input.length; i++) {
            assertEquals(romanNumeralsRestController.toRoman(input[i]), expected[i]);
        }
    }
}
