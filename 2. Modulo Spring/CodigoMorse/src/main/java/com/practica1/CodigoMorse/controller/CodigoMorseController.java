package com.practica1.CodigoMorse.controller;

import com.practica1.CodigoMorse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    private final ICodigoMorseService service;

    @Autowired
    public CodigoMorseController(ICodigoMorseService service) {
        this.service = service;
    }

    @GetMapping("/convertir-morse/{codigoMorse}")
    public String convertirCodigoMorse(@PathVariable String codigoMorse){
        return service.convertirATexto(codigoMorse);
    }

    @GetMapping("/convertir-texto/{texto}")
    public String convertirTexto(@PathVariable String texto){
        return service.convertirAMorse(texto);
    }
}
