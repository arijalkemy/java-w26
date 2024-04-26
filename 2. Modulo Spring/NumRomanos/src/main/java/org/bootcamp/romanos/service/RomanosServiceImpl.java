package org.bootcamp.romanos.service;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class RomanosServiceImpl implements IRomanosService {
    private static final TreeMap<Integer, String> map = new TreeMap<>();

    static{
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    @Override
    public String arabicToRoman(int arabic) {
        for (int key : map.descendingKeySet()) {
            if (arabic >= key) {
                return map.get(key) + arabicToRoman(arabic - key);
            }
        }
        return "";
    }

    @Override
    public int romanToArabic(String roman) {
        int result = 0;
        int i = 0;
        for(int key : map.descendingKeySet()) {
            while(roman.startsWith(map.get(key), i)) {
                result += key;
                i += map.get(key).length();
            }
        }
        return result;
    }
}
