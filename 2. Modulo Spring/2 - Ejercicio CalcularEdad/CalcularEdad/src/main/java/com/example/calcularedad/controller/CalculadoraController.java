package com.example.calcularedad.controller;

import com.example.calcularedad.service.CalcularEdad;
import com.example.calcularedad.service.ICalcularEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class CalculadoraController {

    @Autowired
    public ICalcularEdad serviceCalcularEdad;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int ObtenerEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return serviceCalcularEdad.calcularEdad(dia, mes, anio);
    }
}
