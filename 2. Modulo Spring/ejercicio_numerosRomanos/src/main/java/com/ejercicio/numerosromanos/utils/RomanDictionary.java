package com.ejercicio.numerosromanos.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanDictionary {
    public static TreeMap<Integer, String> romanMap = createRomanMap();
    private static TreeMap<Integer, String> createRomanMap() {
        TreeMap<Integer, String> romanMap = new TreeMap<Integer, String>();

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        return romanMap;
    }
}
