package org.mercadolibre.codigomorse.controllers;

import org.mercadolibre.codigomorse.services.MorseServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    MorseServiceImpl morseService = new MorseServiceImpl();

    @GetMapping("/decodificar/{codigoMorse}")
    public String decodificar(@PathVariable String codigoMorse){
        return morseService.decodificar(codigoMorse);
    }

    @GetMapping("/codificar/{oracion}")
    public String codificar(@PathVariable String oracion){
        return morseService.codificar(oracion);
    }

}
