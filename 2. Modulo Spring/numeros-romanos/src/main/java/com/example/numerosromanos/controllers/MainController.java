package com.example.numerosromanos.controllers;


import com.example.numerosromanos.controllers.services.ConversorNumerosANumerosRomanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final ConversorNumerosANumerosRomanos conversorNumerosANumerosRomanos;

    public MainController(ConversorNumerosANumerosRomanos conversorNumerosANumerosRomanos) {
        this.conversorNumerosANumerosRomanos = conversorNumerosANumerosRomanos;
    }

    @GetMapping("/numero/{numero}")
    public String getSaludo(@PathVariable int numero){
        return conversorNumerosANumerosRomanos.convertirANumeroRomano(numero);
    }

}
