package com.example.introduccion_a_springp2pg;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RomanService implements IRomanService{
    @Override
    public ResponseDTO toNumber(String romanNumber) {

        // Crear un diccionario para asociar los valores numéricos con los caracteres romanos
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        // Inicializar el resultado
        Integer decimal = 0;


        //Convertimos a mayusculas
        romanNumber = romanNumber.toUpperCase();
        if(!romanNumber.matches("[MDCLXVI]+")){
            return new ResponseDTO("Datos no permitidos");
        }

        // Iterar sobre los caracteres del número romano
        for (int i = 0; i < romanNumber.length(); i++) {
            // Obtener el valor numérico del carácter actual
            int value1 = romanValues.get(romanNumber.charAt(i));

            // Si hay un carácter después del actual y su valor es mayor, restar
            if (i + 1 < romanNumber.length()) {
                int value2 = romanValues.get(romanNumber.charAt(i + 1));
                if (value1 >= value2) {
                    decimal += value1;
                } else {
                    decimal += value2 - value1;
                    i++;
                }
            } else {
                decimal += value1;
            }
        }

        return new ResponseDTO(decimal.toString());
    }

    @Override
    public ResponseDTO toRoman(Integer number) {
        // Definir los símbolos romanos y sus valores equivalentes
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] decimalValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        // Crear una cadena para almacenar el número romano resultante
        StringBuilder roman = new StringBuilder();

        // Iterar sobre los símbolos romanos en orden descendente
        for (int i = decimalValues.length - 1; i >= 0; i--) {
            // Mientras el número sea mayor o igual al valor actual
            while (number >= decimalValues[i]) {
                // Agregar el símbolo romano al resultado
                roman.append(romanSymbols[i]);
                // Restar el valor decimal correspondiente
                number -= decimalValues[i];
            }
        }
        return new ResponseDTO(roman.toString());
    }

}
