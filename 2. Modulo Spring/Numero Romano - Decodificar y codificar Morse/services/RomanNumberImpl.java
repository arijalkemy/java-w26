package org.example.apitest.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("romanNumberImpl")
@Primary
public class RomanNumberImpl implements IRomanNumber {

    private final Map<Integer, String> integerRoman;

    public RomanNumberImpl(@Qualifier("integerRoman") Map<Integer, String> integerRoman) {
        this.integerRoman = integerRoman;
    }

    private String convert(Integer decimal, int idx) {
        List<Integer> values = integerRoman.keySet().stream().toList();
        if (idx >= values.size() || decimal == 0) return "";
        int temp = decimal - values.get(idx);
        if (temp >= 0) return integerRoman.get(values.get(idx)) + convert(decimal - values.get(idx), idx);
        return convert(decimal, idx + 1);
    }

    @Override
    public String convertDecimalToRoman(Integer decimal) {
        return convert(decimal, 0);
    }
}
