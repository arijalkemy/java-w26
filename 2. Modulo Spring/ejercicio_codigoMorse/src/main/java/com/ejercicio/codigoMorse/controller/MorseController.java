package com.ejercicio.codigoMorse.controller;

import com.ejercicio.codigoMorse.services.interfaces.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    ICodigoMorseService codigoMorseService;

    @GetMapping("/morseToSpanish/{morseCode}")
    public String translateToSpanish(@PathVariable String morseCode) {
        return codigoMorseService.morseToSpanish(morseCode);
    }

    @GetMapping("/spanishToMorse/{text}")
    public String translateToMorse(@PathVariable String text) {
        return codigoMorseService.spanishToMorse(text);
    }
}
