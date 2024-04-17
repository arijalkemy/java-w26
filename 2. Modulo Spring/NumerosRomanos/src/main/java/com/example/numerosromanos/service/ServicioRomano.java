package com.example.numerosromanos.service;

import org.springframework.stereotype.Service;

@Service
public class ServicioRomano {
    // Servicio que convierte un número entero a número romano
    public String convertirARomano(int numero) {
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                numero -= valores[i];
                resultado.append(romanos[i]);
            }
        }

        return resultado.toString();
    }


}
