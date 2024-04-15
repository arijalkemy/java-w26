package com.codigo.morse.controller;

import com.codigo.morse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {


    @Autowired
    private ICodigoMorseService codigoMorseService;

    @GetMapping("/morse-alfabeto/{codigo}")
    public String CodigoMorseController(@PathVariable String codigo) {

        return codigoMorseService.getTraduccionMorseAAlfabeto(codigo);
    }

    @GetMapping("/alfabeto-morse/{codigo}")
    public String CodigoAlfabetoController(@PathVariable String codigo) {

        return codigoMorseService.getTraduccionAlfabetoAMorse(codigo);
    }
}

