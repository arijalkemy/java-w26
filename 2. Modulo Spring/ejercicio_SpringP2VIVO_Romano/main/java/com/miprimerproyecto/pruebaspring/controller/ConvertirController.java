package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.service.IConvertirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertirController {
    @Autowired
    IConvertirService numero;

    @GetMapping("/convertir/{numero}")
    public String convertirANumeroRomano(@PathVariable int numero) {
        // Definir los símbolos romanos y sus valores decimales correspondientes
        String[] simbolosRomanos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] valoresDecimales = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder resultado = new StringBuilder();

        // Iterar a través de los símbolos romanos
        int indice = valoresDecimales.length - 1; // Comenzar desde el símbolo de mayor valor
        while (numero > 0) {
            int divisor = numero / valoresDecimales[indice];
            numero %= valoresDecimales[indice];
            while (divisor > 0) {
                resultado.append(simbolosRomanos[indice]);
                divisor--;
            }
            indice--;
        }

        return resultado.toString();
    }
}
