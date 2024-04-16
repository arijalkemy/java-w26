package org.ejercicio.numerosromanos.controllers;

import org.ejercicio.numerosromanos.services.IRomano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RomanosController {

    @Autowired
    private IRomano romanoService;

    @GetMapping("/{numero}")
    public String romanos(@PathVariable Integer numero) {
        return romanoService.getRomano(numero);
    }
}
