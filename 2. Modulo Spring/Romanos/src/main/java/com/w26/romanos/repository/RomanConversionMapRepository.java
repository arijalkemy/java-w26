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
    
    public String getRoman(Integer key) {
        return RomanConversionMapRepository.mapaToRoman.get(key);
    }
}
