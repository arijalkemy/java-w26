package com.demospring.numerosromanos.controllers;

import com.demospring.numerosromanos.services.ICodigoMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorseController {
    @Autowired
    ICodigoMorse codigoMorse;

    @GetMapping("/decodificar")
    public String decodificar(@RequestParam String codigo) {
        return codigoMorse.decodificar(codigo);
    }

    @GetMapping("/codificar")
    public String codificar(@RequestParam String texto) {
        return codigoMorse.codificar(texto);
    }
}
