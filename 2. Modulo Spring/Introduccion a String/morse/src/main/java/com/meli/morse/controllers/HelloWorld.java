package com.meli.morse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/*
@RestController
public class HelloWorld {
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hola " + name;
    }

    @GetMapping("/despedida/{name}")
    public String sayBye(@PathVariable String name) {
        return "Adios " + name;
    }

    @GetMapping("/romanos/{numeroRomano}")
    public String darNumero(@PathVariable String numeroRomano) {



        int decimal = 0;
        int prevValue = 0;

        numeroRomano = numeroRomano.toUpperCase(Locale.ROOT);
        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            if(romanToDecimal.containsKey(numeroRomano.charAt(i))){
                int value = romanToDecimal.get(numeroRomano.charAt(i));

                if (value < prevValue) {
                    decimal -= value;
                } else {
                    decimal += value;
                }
                prevValue = value;
            }
            else { decimal = 0;break;}
        }

        return ;
    }

}*/
