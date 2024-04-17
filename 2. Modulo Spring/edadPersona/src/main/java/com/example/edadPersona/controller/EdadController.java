package com.example.edadPersona.controller;

import com.example.edadPersona.service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @Autowired
    private IEdadService iEdadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int devolverEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return iEdadService.calcularEdad(dia, mes, anio);
    }
}
