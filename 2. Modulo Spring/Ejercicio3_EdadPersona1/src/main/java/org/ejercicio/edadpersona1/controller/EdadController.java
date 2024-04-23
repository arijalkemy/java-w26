package org.ejercicio.edadpersona1.controller;

import org.ejercicio.edadpersona1.service.IEdadPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @Autowired
    private IEdadPersona edadPersona;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int obtenerEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return edadPersona.calcularEdad(dia,mes,anio);
    }

}
