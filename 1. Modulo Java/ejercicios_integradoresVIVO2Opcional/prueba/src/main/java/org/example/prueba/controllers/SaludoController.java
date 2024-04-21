package org.example.prueba.controllers;

import org.example.prueba.services.ISaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludos")
public class SaludoController {

    @Autowired
    ISaludoService saludoService;

    @GetMapping("/primero/{name}")
    public String saludo(@PathVariable String name) {
        return saludoService.saludo(name);
    }
}
