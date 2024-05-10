package org.example.romansnumbertesting.service.impl;

import org.example.romansnumbertesting.dto.RomanDto;
import org.example.romansnumbertesting.service.IRomanService;
import org.springframework.stereotype.Service;

@Service
public class RomanServiceImpl implements IRomanService {
    private final int[] numbers;
    private final String[] roman;

    public RomanServiceImpl() {
        numbers = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 3, 1};
        roman = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "I" };
    }

    private String convertNumberToRoman(Integer number, int index) {
        if (number == 0) return "";
        if (number - numbers[index] >= 0) return roman[index] + convertNumberToRoman(number - numbers[index], index);
        return convertNumberToRoman(number, index + 1);
    }

    @Override
    public RomanDto encodeRomanNumber(Integer number) {
        return new RomanDto(convertNumberToRoman(number, 0));
    }
}
