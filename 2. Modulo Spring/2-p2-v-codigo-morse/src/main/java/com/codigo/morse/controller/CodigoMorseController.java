package com.codigo.morse.controller;

import com.codigo.morse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {


    @Autowired
    private ICodigoMorseService codigoMorseService;

    @GetMapping("/morse-alfabeto/{codigo}")
    public ResponseEntity<String> CodigoMorseController(@PathVariable String codigo) {

        String alfabetoString = codigoMorseService.getTraduccionMorseAAlfabeto(codigo);
        return ResponseEntity.ok(alfabetoString);
    }

    @GetMapping("/alfabeto-morse/{codigo}")
    public ResponseEntity<String> CodigoAlfabetoController(@PathVariable String codigo) {

        String codigoMorse = codigoMorseService.getTraduccionAlfabetoAMorse(codigo);

        return ResponseEntity.ok(codigoMorse);
    }
}

