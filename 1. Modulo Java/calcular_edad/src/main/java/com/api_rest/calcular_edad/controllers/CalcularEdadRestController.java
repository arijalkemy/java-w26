package com.api_rest.calcular_edad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular_edad")
public class CalcularEdadRestController {

    @Autowired
    IEdad edad;

    @GetMapping("/calcular/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return edad.calcularEdad(dia, mes, anio);
    }
}
