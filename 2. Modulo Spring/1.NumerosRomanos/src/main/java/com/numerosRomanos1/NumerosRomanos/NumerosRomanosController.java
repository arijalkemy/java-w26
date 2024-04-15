package com.numerosRomanos1.NumerosRomanos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class NumerosRomanosController {

    @GetMapping("/{numeroEntero}")
    public String convierteNumero(@PathVariable Integer numeroEntero){
        return "El numero ingresado es: "+ Converter.intToRoman(numeroEntero);
    }
}
