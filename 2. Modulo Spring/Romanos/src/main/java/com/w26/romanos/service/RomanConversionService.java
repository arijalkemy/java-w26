package com.w26.romanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w26.romanos.components.RomanConversorComponent;

@Service
public class RomanConversionService implements IRomanConversionService {
   
    @Autowired
    private RomanConversorComponent romanConversorComponent;
    

    @Override
    public String decimalToRoman(Integer decimal) {
       return romanConversorComponent.integerToRoman(decimal);
    }

    @Override
    public Integer romanToDecimal(String roman) {
        return romanConversorComponent.romanToInteger(roman);
    }
}
