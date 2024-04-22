package com.spring.numerosromanos.service;

import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class NumerosRomanosServiceImpl implements INumerosRomanosService {

        private static final TreeMap<Integer, String> romanMap = new TreeMap<>();

        static {
            romanMap.put(1, "I");
            romanMap.put(4, "IV");
            romanMap.put(5, "V");
            romanMap.put(9, "IX");
            romanMap.put(10, "X");
            romanMap.put(40, "XL");
            romanMap.put(50, "L");
            romanMap.put(90, "XC");
            romanMap.put(100, "C");
            romanMap.put(400, "CD");
            romanMap.put(500, "D");
            romanMap.put(900, "CM");
            romanMap.put(1000, "M");
        }

        public String decimalToRoman(int number) {
            int floorValue = romanMap.floorKey(number);
            if (number == floorValue) {
                return romanMap.get(number);
            }
            return romanMap.get(floorValue) + decimalToRoman(number - floorValue);
        }

}
