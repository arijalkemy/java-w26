package com.romanos.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/converter")
public class NumberController {

    @GetMapping("/{decimal}")
    public String romanoConverter(@PathVariable int decimal){
        Map<String, Integer> mapaNumerosRomanos = new LinkedHashMap<>();

        mapaNumerosRomanos.put("M", 1000);
        mapaNumerosRomanos.put("CM", 900);
        mapaNumerosRomanos.put("D", 500);
        mapaNumerosRomanos.put("CD", 400);
        mapaNumerosRomanos.put("C", 100);
        mapaNumerosRomanos.put("XC", 90);
        mapaNumerosRomanos.put("L", 50);
        mapaNumerosRomanos.put("XL", 40);
        mapaNumerosRomanos.put("X", 10);
        mapaNumerosRomanos.put("IX", 9);
        mapaNumerosRomanos.put("V", 5);
        mapaNumerosRomanos.put("IV", 4);
        mapaNumerosRomanos.put("I", 1);


        StringBuilder resultado = new StringBuilder();

        for (Map.Entry<String, Integer> entrada : mapaNumerosRomanos.entrySet()) {
            String romano = entrada.getKey();
            int valor = entrada.getValue();

            while (decimal >= valor) {
                resultado.append(romano);
                decimal -= valor;
            }
        }

        return resultado.toString();
    }
}
