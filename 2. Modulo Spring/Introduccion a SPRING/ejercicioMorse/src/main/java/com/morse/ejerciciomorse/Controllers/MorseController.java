package com.morse.ejerciciomorse.Controllers;

import com.morse.ejerciciomorse.services.ITranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("converter")
public class MorseController {

    @Autowired
    ITranslator translatorService;

    @GetMapping("/morse/{codigoMorse}")
    public String morseAString(@PathVariable String codigoMorse) {

        String resultado = translatorService.translateToEspa(codigoMorse);

        return resultado;
    }

    @GetMapping("/espa/{palabras}")
    public String espaAMorse(@PathVariable String palabras) {

        String resultado = translatorService.translateToMorse(palabras);

        return resultado;
    }
}
