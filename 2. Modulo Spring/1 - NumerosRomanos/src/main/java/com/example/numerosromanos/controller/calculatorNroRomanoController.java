package com.example.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calculatorNroRomanoController {

    @GetMapping("/{number}")
    public String toRoman(@PathVariable Integer number) {
        //Clase StringBuilder provee un constructor de Strings, que agregar un string seguido de otro.
        StringBuilder romanNumber = new StringBuilder();
        //Se generan arrays para comparar valor entero a romano
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        //Se recorren los numeros enteros a comparar
        for (int i = 0; i < numbersToCompare.length; i++)
            // Se omite la inicializacion, en la condicion se verifica si el numero es >= a posicion en lista,
            // de ser asi, al numero ingresado se le resta el valor y continua el ciclo.
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);
        return romanNumber.toString();
    }
}
