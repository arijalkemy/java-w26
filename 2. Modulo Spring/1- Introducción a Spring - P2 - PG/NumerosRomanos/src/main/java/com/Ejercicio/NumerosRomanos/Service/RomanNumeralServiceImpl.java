package com.Ejercicio.NumerosRomanos.Service;

import com.Ejercicio.NumerosRomanos.Interface.RomanNumeralService;
import com.github.fracpete.romannumerals4j.RomanNumeralFormat;
import org.springframework.stereotype.Service;


@Service
public class RomanNumeralServiceImpl implements RomanNumeralService {

    @Override
    public String convertToRoman(int number) {
        RomanNumeralFormat formatInt = new RomanNumeralFormat();
        return formatInt.format(number);
    }


}
