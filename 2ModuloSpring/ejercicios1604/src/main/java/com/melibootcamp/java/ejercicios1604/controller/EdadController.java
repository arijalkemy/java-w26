package com.melibootcamp.java.ejercicios1604.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.melibootcamp.java.ejercicios1604.serviceImp.EdadSeriveImp;

@RestController
public class EdadController {
    @Autowired
    EdadSeriveImp edadService;


    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes,@PathVariable int anio ){
        return edadService.obtenerAnios(dia,mes,anio);
    }

    @GetMapping()
    public String defaultRespone(){
        return "Hola, funciona";
    }

}
