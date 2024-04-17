package com.example.edadpersonas.controller;

import com.example.edadpersonas.service.IEdadPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {
    @Autowired
    IEdadPersona edadPersonaService;
    @GetMapping("/{dia}/{mes}/{ano}")
    public int getEdadPersona(
            @PathVariable int dia,
            @PathVariable int mes,
            @PathVariable int ano
    ) {
        return edadPersonaService.getEdadPersona(dia, mes, ano);
    }
}
