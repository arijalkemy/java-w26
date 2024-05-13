package com.w26.romanos.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class RomanConversionMapRepository {
    private final static Map<Integer, String> mapaToRoman= Map.ofEntries(
            Map.entry(1, "I"),
            Map.entry(10, "X"),
            Map.entry(100, "C"),
            Map.entry(1000, "M"),
            Map.entry(5, "V"),
            Map.entry(50, "L"),
            Map.entry(500, "D"));
    
    private final static Map<Character, Integer> mapaToInteger= Map.ofEntries(
            Map.entry('I',1),
            Map.entry('X', 10),
            Map.entry('C', 100),
            Map.entry('M', 1000),
            Map.entry('V', 5),
            Map.entry('L', 50),
            Map.entry('D', 500));
    
    public String getRoman(Integer key) {
        return RomanConversionMapRepository.mapaToRoman.get(key);
    }

    public Integer getInteger(Character key) {
        return RomanConversionMapRepository.mapaToInteger.get(key);
    }
}
