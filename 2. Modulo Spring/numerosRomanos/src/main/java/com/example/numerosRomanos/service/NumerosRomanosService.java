package com.example.numerosRomanos.service;

import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosService implements INumerosRomanosService{


    @Override
    public String convertToRoman(int decimal) {
        if (decimal < 1 || decimal > 3999) {
            return "Número fuera de rango";
        }
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romanNumeral = new StringBuilder();
        int i = 0;
        while (decimal > 0) {
            if (decimal - decimalValues[i] >= 0) {
                romanNumeral.append(romanSymbols[i]);
                decimal -= decimalValues[i];
            } else {
                i++;
            }
        }
        return romanNumeral.toString();
    }
}
