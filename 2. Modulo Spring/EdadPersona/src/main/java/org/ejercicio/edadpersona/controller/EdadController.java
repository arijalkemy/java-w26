package org.ejercicio.edadpersona.controller;

import org.ejercicio.edadpersona.service.IEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @Autowired
    private IEdad edadService;

    @GetMapping("/")
    public int obtenerEdad(@RequestParam int dia, @RequestParam int mes, @RequestParam int anio){
        return edadService.obtenerAnios(dia, mes, anio);
    }
}
