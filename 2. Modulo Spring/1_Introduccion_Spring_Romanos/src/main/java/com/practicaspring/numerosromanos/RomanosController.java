package com.practicaspring.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

    @RestController
    public class RomanosController {
        @GetMapping("/convertir/{number}")
        public String convertir(@PathVariable int number) {
            String[] miles = {"","M","MM","MMM","MMMM"};
            String[] centenas = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
            String[] decenas = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String[] unidades = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
            String convertedDecimal = miles[number / 1000] + centenas[(number % 1000) / 100] + decenas[(number % 100) / 10] + unidades[number % 10];

            return convertedDecimal;
        }
    }
