package com.miprimerproyecto.prueba.controller;

import com.miprimerproyecto.prueba.servicios.ITraducible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class TraduccionController {
    @Autowired
    ITraducible morseService;

    @GetMapping("/pasarAEspanol/{morse}")
    public String pasarAEspanol(@PathVariable String morse){
        return morseService.obtenerResultadoDeTraduccionAEspanol(morse);
    }

    @GetMapping("/pasarAMorse/{espanol}")
    public String pasarAMorse(@PathVariable String espanol){
        return morseService.obtenerResultadoDeTraduccionAMorse(espanol);
    }
}
