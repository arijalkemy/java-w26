package com.numerosRomanos1.NumerosRomanos.controllers;


import com.numerosRomanos1.NumerosRomanos.services.Converter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class NumerosRomanosController {

    @GetMapping("/{intNumber}")
    public String convierteNumero(@PathVariable Integer intNumber){
        return "El numero ingresado es: "+ Converter.intToRoman(intNumber);
    }
}
