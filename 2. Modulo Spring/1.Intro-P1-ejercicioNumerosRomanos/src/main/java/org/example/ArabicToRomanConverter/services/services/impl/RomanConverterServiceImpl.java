package org.example.ArabicToRomanConverter.services.services.impl;

import org.example.ArabicToRomanConverter.services.IromanConverterService;
import org.springframework.stereotype.Service;

@Service
public class RomanConverterServiceImpl implements IromanConverterService {
    @Override
    public String convertToRoman(Integer arabic) {
        // Los numero romanos solo pueden representar alores arabicos entre 1 y 3999
        if (arabic < 1 || arabic > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        int[] arabics = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (arabic > 0) {
            if (arabic >= arabics[index]) {
                result.append(romans[index]);
                arabic -= arabics[index];
            } else {
                index++;
            }
        }

        return result.toString();
    }
}
