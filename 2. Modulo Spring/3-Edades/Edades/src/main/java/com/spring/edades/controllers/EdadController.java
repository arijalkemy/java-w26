package com.spring.edades.controllers;

import com.spring.edades.services.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    IEdadService edadService;

    @GetMapping("{dia}/{mes}/{anio}")
    public Integer obtenerEdad(@PathVariable Integer dia,
                               @PathVariable Integer mes,
                               @PathVariable Integer anio){
        return edadService.calcularEdad(dia, mes, anio);
    }
}
