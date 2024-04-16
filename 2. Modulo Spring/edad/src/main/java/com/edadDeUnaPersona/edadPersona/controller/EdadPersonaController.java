package com.edadDeUnaPersona.edadPersona.controller;

import com.edadDeUnaPersona.edadPersona.service.IEdadPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {
    final IEdadPersonaService personaService;

    public EdadPersonaController(IEdadPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public int obtenerEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return this.personaService.obtenerEdad(dia, mes, anio);
    }

}
