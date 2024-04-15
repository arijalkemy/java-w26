package com.practica1.numerosRomanos.controller;

import com.practica1.numerosRomanos.service.INumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    private final INumerosRomanosService service;

    @Autowired
    public NumerosRomanosController(INumerosRomanosService service) {
        this.service = service;
    }

    @GetMapping("/{numeroDecimal}")
    public String obtenerNumeroRomano(@PathVariable int numeroDecimal){
        return service.obtenerNumeroRomano(numeroDecimal);
    }
}
