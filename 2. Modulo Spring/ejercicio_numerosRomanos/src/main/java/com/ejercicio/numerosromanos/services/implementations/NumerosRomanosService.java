package com.ejercicio.numerosromanos.services.implementations;

import com.ejercicio.numerosromanos.services.interfaces.INumerosRomanosService;
import com.ejercicio.numerosromanos.utils.RomanDictionary;
import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosService implements INumerosRomanosService {
    @Override
    public String convert(Integer number) {
        int base = RomanDictionary.romanMap.floorKey(number);
        if (base == number) return RomanDictionary.romanMap.get(number);
        return RomanDictionary.romanMap.get(base) + convert(number - base);
    }
}
