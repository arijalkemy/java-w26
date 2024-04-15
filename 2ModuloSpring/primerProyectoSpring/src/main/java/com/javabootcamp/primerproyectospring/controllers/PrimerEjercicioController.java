package com.javabootcamp.primerproyectospring.controllers;

import com.javabootcamp.primerproyectospring.services.ConverterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimerEjercicioController {
    @Autowired
    private ConverterServices convertService;
    /**
     * convierte un numero entero de formato tradicional a numero romano usando la libreria romannumerals4j
     * @method GET
     * @param  numero numero que transformaremos a Romano ej(100, 14, 21)
     * @return numero formateado en romano
     */
    @GetMapping("/primerejercicio/{number}")
    public String primerEjercicio(@PathVariable int numero){
        return "el numero ingresado fue "+ numero +" en numero romano es igual a "+convertService.enteroARomano(numero);
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

    @GetMapping("/segundoEjercicio/morseATexto/{morse}")
    public String morseATexto(@PathVariable String morse){
        return "usted ingreso "+morse+" la traduccion es "+ convertService.morseATexto(morse);
    }
    @GetMapping("/segundoEjercicio/textoAMorse/{texto}")
    public String textoaMorse(@PathVariable String texto){
        return "usted ingreso "+texto+" la traduccion a morse es "+ convertService.textoAMorse(texto);
    }
}
