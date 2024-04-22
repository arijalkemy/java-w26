package com.romanos.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String transformarARomanos(@PathVariable int numero){

        StringBuilder resultado = new StringBuilder();

        String[] simbolos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] valores = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int indice = valores.length - 1;

        while (numero > 0) {
            int divisor = valores[indice];
            int cociente = numero / divisor;
            numero %= divisor;
            while (cociente-- > 0) {
                resultado.append(simbolos[indice]);
            }
            indice--;
        }

        return resultado.toString();
    }
}
