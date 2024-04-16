package com.example.c2edadpersona.controller;

import com.example.c2edadpersona.service.IEdadPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EdadPersonaController {

    @Autowired
    IEdadPersonaService edadPersonaService;

    @GetMapping("/edad-persona/{dia}/{mes}/{anio}")
    public Integer edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        return edadPersonaService.edadPersona(dia, mes, anio);
    }
}
