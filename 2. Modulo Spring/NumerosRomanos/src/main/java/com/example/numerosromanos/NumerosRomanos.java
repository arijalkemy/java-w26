package com.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {
    @GetMapping("/{numero}")
    public String toRoman(@PathVariable Integer numero) {
        StringBuilder resultado = new StringBuilder();
        String[] romanos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] decimales = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        int indice = romanos.length-1;


        // mientras que el número sea mayor que 0, continuamos construyendo el número romano
        while (numero > 0) {
            // Verificamos que el número a convertir es mayor o igual al valor más grande
            if (numero >= decimales[indice]) {
                // Agregamos el símbolo Romano
                resultado.append(romanos[indice]);
                // Reduce el número restando el valor romano que ya hemos representado
                numero -= decimales[indice];
            } else {
                // reducimos el índice para verificar el siguiente valor romano en los arreglos de decimales
                indice--;
            }
        }
        return resultado.toString();
    }
}