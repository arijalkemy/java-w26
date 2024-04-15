package com.example.numerosromanos.controllers.services;

import org.springframework.stereotype.Service;

@Service
public class ConversorNumerosANumerosRomanos {
    String[] simbolos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int[] valores = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String convertirANumeroRomano(int numero){
        StringBuilder resultado = new StringBuilder();

        for (int i = valores.length - 1; i >= 0; i--) {
            while (numero >= valores[i]) {
                resultado.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return resultado.toString();
    }

}
