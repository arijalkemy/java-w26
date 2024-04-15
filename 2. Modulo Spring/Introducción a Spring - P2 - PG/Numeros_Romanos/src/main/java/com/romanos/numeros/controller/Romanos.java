package com.romanos.numeros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Romanos {

    private static final int[] DECIMAL_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping("/romano/{numero}")
    public String devolverRomano(@PathVariable int numero) {
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = 0; i < DECIMAL_VALUES.length; i++) {
            while (numero >= DECIMAL_VALUES[i]) {
                numero -= DECIMAL_VALUES[i];
                romanNumeral.append(ROMAN_NUMERALS[i]);
            }
        }
        return romanNumeral.toString();
    }
}
