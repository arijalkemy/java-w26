package com.numerosRomanos.controller;

import com.numerosRomanos.service.numerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class numerosRomanosController {

    @Autowired
    numerosRomanosService numerosService;
    @GetMapping("/decimalRomano/{numero}")
    public String decimalRomano(@PathVariable Integer numero){
        return numerosService.decimalRomano(numero);
    }
}
