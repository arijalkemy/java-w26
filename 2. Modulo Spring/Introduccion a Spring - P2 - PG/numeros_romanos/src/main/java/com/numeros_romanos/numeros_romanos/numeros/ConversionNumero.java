package com.numeros_romanos.numeros_romanos.numeros;

import org.springframework.stereotype.Service;

@Service
public class ConversionNumero implements INumeroConversion{
    @Override
    public String conversionNumero(String decimalNumberString) {
        int decimalNumber = Integer.parseInt(decimalNumberString);

        if (decimalNumber <= 0 || decimalNumber > 3999) {
            throw new IllegalArgumentException("El numero debe de encontrarse entre 0 y 3999");
        }

        // Arrays para almacenar los símbolos romanos y sus equivalentes decimales
        int[] valoresDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();

        // Iterar sobre los valores decimales
        for (int i = 0; i < valoresDecimales.length; i++) {
            // Mientras el número decimal sea mayor o igual al valor decimal actual
            while (decimalNumber >= valoresDecimales[i]) {
                // Concatenar el símbolo romano correspondiente
                resultado.append(simbolosRomanos[i]);
                // Restar el valor decimal actual al número decimal
                decimalNumber -= valoresDecimales[i];
            }
        }

        return resultado.toString();
    }
}
