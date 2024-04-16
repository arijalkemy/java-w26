package com.ejercicio.numerosromanos.controllers;

import com.ejercicio.numerosromanos.services.interfaces.INumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @Autowired
    INumerosRomanosService numerosRomanosService;

    @GetMapping("/convert/{number}")
    public String convertToRomanos(@PathVariable Integer number) {
        return numerosRomanosService.convert(number);
    }
}
