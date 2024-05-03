package com.EjercicioSpring.Ejercicio3_NumerosRomanos.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RomanNumbersImpl implements RomanNumbersService {

    private TreeMap<Integer, String> romanNumbers = getRomanNumbers();
    @Override
    public String convertDecimalToRoman(int x) {
        String value = "";
        if (x < 0) {
            value += "-";
            x = Math.abs(x);
        }
        if (x == 0) {
            return "";
        }
        int y = romanNumbers.floorKey(x);
        return value + romanNumbers.get(y) + convertDecimalToRoman(x - y);
    }

    public TreeMap<Integer, String> getRomanNumbers() {
        TreeMap<Integer, String> romanNumbers = new TreeMap<>();
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
        romanNumbers.put(400, "CD");
        romanNumbers.put(500, "D");
        romanNumbers.put(900, "CM");
        romanNumbers.put(1000, "M");
        return romanNumbers;
    }
}
