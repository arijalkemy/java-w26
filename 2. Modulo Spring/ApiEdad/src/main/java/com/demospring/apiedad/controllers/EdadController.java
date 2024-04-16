package com.demospring.apiedad.controllers;

import com.demospring.apiedad.services.IEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    IEdad edadService;

    @GetMapping(path = "/{dia}/{mes}/{anio}")
    public int obtenerEdad(@PathVariable int dia,
                                 @PathVariable int mes,
                                 @PathVariable int anio) {
        return edadService.calcularEdad(dia, mes, anio);

    }
}
