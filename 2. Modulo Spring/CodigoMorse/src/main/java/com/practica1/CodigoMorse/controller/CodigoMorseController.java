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

    @GetMapping("/{codigoMorse}")
    public String convertirCodigoMorse(@PathVariable String codigoMorse){
        return service.convertirCodigoMorse(codigoMorse);
    }
}
