package com.mercadolibre.romannumerals.Unitary;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RomanNumbersTest {

    @Test
    @DisplayName("Probar numeros romanos esperando resultado correcto")
    public void TestControllerRoman()
    {

        RomanNumeralsRestController romanNumbersTest = new RomanNumeralsRestController();
        Assertions.assertEquals ("I", romanNumbersTest.toRoman(1));
        Assertions.assertEquals ("III", romanNumbersTest.toRoman(3));
        Assertions.assertEquals ("V", romanNumbersTest.toRoman(5));
        Assertions.assertEquals ("VII", romanNumbersTest.toRoman(7));
        Assertions.assertEquals ("X", romanNumbersTest.toRoman(10));
        Assertions.assertEquals ("L", romanNumbersTest.toRoman(50));

    }


}
