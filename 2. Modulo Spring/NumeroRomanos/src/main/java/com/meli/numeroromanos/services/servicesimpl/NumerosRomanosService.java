package com.meli.numeroromanos.services.servicesimpl;

import com.meli.numeroromanos.services.INumerosRomanos;
import org.springframework.stereotype.Service;

import static com.meli.numeroromanos.modelo.RomanoDiccionario.ROMAN_NUMERALS;

@Service
public class NumerosRomanosService implements INumerosRomanos {

    @Override
    public String encode(int number) {
        int floorKey = ROMAN_NUMERALS.floorKey(number);
        if (number == floorKey) {
            return ROMAN_NUMERALS.get(number);
        }
        return ROMAN_NUMERALS.get(floorKey) + encode(number - floorKey);
    }

    @Override
    public String decode(int numero) {
        return "";
    }
}
