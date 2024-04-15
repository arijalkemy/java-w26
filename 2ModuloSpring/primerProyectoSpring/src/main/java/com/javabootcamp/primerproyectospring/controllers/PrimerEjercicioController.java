package com.javabootcamp.primerproyectospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.github.fracpete.romannumerals4j.RomanNumeralFormat;

@RestController
public class PrimerEjercicioController {
    /**
     * convierte un numero entero de formato tradicional a numero romano usando la libreria romannumerals4j
     * @method GET
     * @param  number numero que transformaremos a Romano ej(100, 14, 21)
     * @return numero formateado en romano
     */
    @GetMapping("/primerEjercicio/{number}")
    public String primerEjercicio(@PathVariable int number){
        RomanNumeralFormat f = new RomanNumeralFormat();
        return "el numero ingresado fue "+ number +" en numero romano es igual a "+f.format(number);
    }

    /**
     * @method GET
     * @return string "funciona" retrona este mensaje
     * para saber si el proyecto funciona correctamente
     */
    @GetMapping()
    public String basic(){
        return "funciona";
    }
}
