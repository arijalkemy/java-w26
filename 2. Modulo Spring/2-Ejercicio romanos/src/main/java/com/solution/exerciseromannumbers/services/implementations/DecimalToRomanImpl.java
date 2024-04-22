package com.solution.exerciseromannumbers.services.implementations;

import com.solution.exerciseromannumbers.services.IDecimalToRomanService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DecimalToRomanImpl implements IDecimalToRomanService {
    private static final TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    static {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    private String convertToRoman(Integer decimalNumber) {
        Integer closestKey = romanNumerals.floorKey(decimalNumber);

        if (closestKey != null) {
            int numberOfDigitsToWrite = decimalNumber / closestKey;
            String result = "";

            for (int i = 0; i < numberOfDigitsToWrite; i++) {
                result = result + romanNumerals.get(closestKey);
            }

            return result + convertToRoman(decimalNumber % closestKey);
        } else {
            return "";
        }
    }

    @Override
    public String convertDecimalToRoman(Integer decimalNumber) {
        if (decimalNumber > 3999) {
            return "Can't be represented with roman numbers.";
        }

        return convertToRoman(decimalNumber);
    }
}
