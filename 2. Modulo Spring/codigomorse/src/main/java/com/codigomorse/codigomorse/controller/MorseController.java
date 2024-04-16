package com.codigomorse.codigomorse.controller;

import com.codigomorse.codigomorse.service.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertir")
public class MorseController {

    @Autowired
    IMorseService morseService;

    @GetMapping("/texto/{morse}")
    public String convertirATexto(@PathVariable String morse)
    {
        return this.morseService.convertirAPalabra(morse);
    }

    @GetMapping("/morse/{palabra}")
    public String convertirAMorse(@PathVariable String palabra){
        return this.morseService.convertirAMorse(palabra);
    }


}
