package com.practica1.numerosRomanos.controller;

import com.practica1.numerosRomanos.service.NumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @Autowired
    NumerosRomanosService service = new NumerosRomanosService();

    @GetMapping("/{numeroDecimal}")
    public String obtenerNumeroRomano(@PathVariable int numeroDecimal){
        return service.obtenerNumeroRomano(numeroDecimal);
    }
}
