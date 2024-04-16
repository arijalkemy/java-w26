package com.demospring.numerosromanos.controllers;

import com.demospring.numerosromanos.services.INumeroRomano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numeroRomano")
public class NumeroRomanoController {
    @Autowired
    INumeroRomano numeroRomano;

    @GetMapping
    public String convertir(@RequestParam Integer numero) {
        return numeroRomano.convertir(numero);
    }
}
