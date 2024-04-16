package meli.bootcamp.numerosromanos.service;

import org.springframework.stereotype.Service;

public class RomanNumber{

    public static String convertToRoman(int number) {
        if (number <= 0 || number > 3999) {
            return "Number out of range";
        }

        // Arrays to store Roman symbols and their values
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();

        // Iterate over Roman symbols
        for (int i = 0; i < symbols.length; i++) {
            // While the number is greater than or equal to the current value
            while (number >= values[i]) {
                // Add the Roman symbol to the result
                result.append(symbols[i]);
                // Subtract the value from the number
                number -= values[i];
            }
        }

        return result.toString();
    }
}
