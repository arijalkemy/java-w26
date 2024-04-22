package com.bootcamp.edadpersona.controller;

import com.bootcamp.edadpersona.service.ICalcularEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class edadController {

    @Autowired
    ICalcularEdadService calcularEdadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int edadPersona(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio) {
        if(mes< 1 || mes > 12) {
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
        }
        if(dia < 1 || dia > 31) {
            throw new IllegalArgumentException("El dia debe estar entre 1 y 31");
        }
        return calcularEdadService.calcularEdad(dia, mes, anio);
    }
}
