package com.mercadolibre.romannumerals.service;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralsImpl implements IRomanNumerals{
    StringBuilder romanNumber = new StringBuilder();
    int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
    String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
    @Override
    public String getRomanNumerals(Integer number) {
        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);
        return romanNumber.toString();
    }
}
