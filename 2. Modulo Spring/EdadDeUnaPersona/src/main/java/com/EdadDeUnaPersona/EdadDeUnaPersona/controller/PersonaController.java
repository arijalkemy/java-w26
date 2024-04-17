package com.EdadDeUnaPersona.EdadDeUnaPersona.controller;

import com.EdadDeUnaPersona.EdadDeUnaPersona.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @GetMapping(path = "{dia}/{mes}/{anio}")
    public Integer mapEdadPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        return personaService.mapEdadPersona(dia,mes,anio);
    }
}
