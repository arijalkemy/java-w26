package com6.NumerosRomanos.Services.Impl;

import com6.NumerosRomanos.Services.IConversorRomano;
import org.springframework.stereotype.Service;

@Service
public class ConversorRomanoImpl implements IConversorRomano {
    @Override
    public String convertirEnteroARomano(int numero) {
        int[] enteros = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder conversion = new StringBuilder();
        int i = 0;
        while (numero > 0) {
            while (numero >= enteros[i]) {
                numero -= enteros[i];
                conversion.append(romanos[i]);
            }
            i++;
        }
        return conversion.toString();
    }
}
