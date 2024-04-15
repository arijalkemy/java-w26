package com.example.romanNumbers.services.implementations;

import com.example.romanNumbers.services.IDecimalToRomanConverter;
import org.springframework.stereotype.Service;

@Service
public class DecimalToRomanConverterImpl implements IDecimalToRomanConverter {

    @Override
    public String convertToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        // Definimos los símbolos romanos y sus valores correspondientes
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romanNumber = new StringBuilder();

        // Iteramos sobre los símbolos romanos y sus valores correspondientes
        for (int i = 0; i < decimalValues.length; i++) {
            // Mientras el número decimal sea mayor o igual al valor romano actual
            while (number >= decimalValues[i]) {
                // Agregamos el símbolo romano correspondiente al resultado
                romanNumber.append(romanSymbols[i]);
                // Restamos el valor decimal correspondiente al número
                number -= decimalValues[i];
            }
        }

        return romanNumber.toString();
    }
}
