package org.ejercicio.codigomorse.controllers;

import org.ejercicio.codigomorse.services.IMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MorseController {

    @Autowired
    private IMorse morse;

    @GetMapping("frase/{frase}")
    public String obtenerMorse(@PathVariable String frase) {
        return morse.obtenerMorse(frase);
    }

    @GetMapping("morse/{morseTrad}")
    public String obtenerFrase(@PathVariable String morseTrad) {
        return morse.obtenerFrase(morseTrad);
    }
}
