package com.bootcamp.Introduccion.a.Spring.Numeros.Romanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConvertNumber {

    @GetMapping("/romano/{decimalNumber}")
    public String decimalToRoman(@PathVariable int decimalNumber) {
        String[] romanSymbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int[] decimalValues = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

        StringBuilder roman = new StringBuilder();

        for (int i = decimalValues.length - 1; i >= 0; i--) {
            // Mientras el número decimal sea mayor o igual al valor actual
            while (decimalNumber >= decimalValues[i]) {
                // Agregar el símbolo romano correspondiente al resultado
                roman.append(romanSymbols[i]);
                // Restar el valor decimal del número
                decimalNumber -= decimalValues[i];
            }
        }

        return roman.toString();
    }
}
