package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {

    @GetMapping("/convert/{number}")
    public String convertToRoman(@PathVariable int number) {
        if (number < 1 || number > 3999) {
            return "El número debe estar entre 1 y 3999";
        }

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] decimalValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder result = new StringBuilder();
        int i = decimalValues.length - 1;

        while (number > 0) {
            if (number >= decimalValues[i]) {
                result.append(romanSymbols[i]);
                number -= decimalValues[i];
            } else {
                i--;
            }
        }

        return result.toString();
    }
}