package org.example.spring_demo.service;

import org.example.spring_demo.exception.NumberNotValid;
import org.springframework.stereotype.Service;


@Service
public class RomanNumberService implements IRomanNumberService {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override
    public String getRomanNumber(String number) {
        int decimal = Integer.parseInt(number);
        if (decimal < 1 || decimal > 3999) {
            throw new NumberNotValid("Input must be between 1 and 3999");
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (decimal > 0) {
            while (decimal >= values[i]) {
                result.append(numerals[i]);
                decimal -= values[i];
            }
            i++;
        }
        return result.toString();
    }
}
