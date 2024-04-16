package com.example.demo.controller;

import com.example.demo.response.EdadResponse;
import com.example.demo.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {


    private final EdadService edadService;

    @Autowired
    public EdadController(EdadService edadService) {
        this.edadService = edadService;
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        int edad = edadService.calcularEdad(dia, mes, anio);
        return (new EdadResponse(edad)).getEdad();
    }
}