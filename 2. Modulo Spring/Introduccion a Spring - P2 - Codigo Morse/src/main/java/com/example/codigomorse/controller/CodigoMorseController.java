package com.example.codigomorse.controller;

import com.example.codigomorse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    // Constructor para la inyección de dependencias
    @Autowired
    ICodigoMorseService codigoMorseService;
    @GetMapping("/morse-a-texto/{codigoMorse}")
    public String codigoMorseATexto(@PathVariable String codigoMorse) {
        return codigoMorseService.codigoMorseATexto(codigoMorse);
    }
    @GetMapping("/texto-a-morse/{texto}")
    public String textoACodigoMorse(@PathVariable String texto) {
        return codigoMorseService.textoACodigoMorse(texto);
    }
}
