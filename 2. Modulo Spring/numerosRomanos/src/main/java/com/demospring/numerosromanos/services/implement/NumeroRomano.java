package com.demospring.numerosromanos.services.implement;

import com.demospring.numerosromanos.services.INumeroRomano;
import org.springframework.stereotype.Service;

@Service
public class NumeroRomano implements INumeroRomano {
    private static final String[] SIMBOLOS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] VALORES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    @Override
    public String convertir(Integer numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("El numero no puede ser menor a 1 ni mayor a 3999.");
        }
        return convertirARomano(numero);
    }

    private String convertirARomano(int numero) {
        StringBuilder romano = new StringBuilder();
        for (int i = 0; i < SIMBOLOS.length; i++) {
            while (numero >= VALORES[i]) {
                romano.append(SIMBOLOS[i]);
                numero -= VALORES[i];
            }
        }
        return romano.toString();
    }
}
