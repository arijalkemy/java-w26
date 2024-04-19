package com.roman.romannumbers.services.impl;

import com.roman.romannumbers.services.IRomanNumberService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service()
public class IRomanNumberServiceImpl implements IRomanNumberService {

    @Override
    public String parseNumber(int number) {

        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(5, "V");
        romanMap.put(10, "X");
        romanMap.put(50, "L");
        romanMap.put(100, "V");
        romanMap.put(500, "C");
        romanMap.put(1000, "D");




        return "Hello world";
    }
}
