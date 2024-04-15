package com.example.c1numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class NumerosRomanosController {

    @GetMapping("/numeros-romanos/{numero}")
    public String convertirNumeroRomano(@PathVariable int numero) {
        HashMap<Integer, String> numerosRomanos = new HashMap<>();
        numerosRomanos.put(1, "I");
        numerosRomanos.put(2, "II");
        numerosRomanos.put(3, "III");
        numerosRomanos.put(4, "IV");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(7, "VII");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(1000, "M");


        return numerosRomanos.get(numero);
    }
}
