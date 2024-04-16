package com.example.edadpersona.controller;

import com.example.edadpersona.service.IEdadPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/edad")
public class EdadPersonaController {

    @Autowired
    IEdadPersonaService edadPersonaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String obtenerEdad(@PathVariable String dia,@PathVariable String mes,@PathVariable String anio ){
        int edad = edadPersonaService.calcularEdad(  Integer.parseInt(dia),  Integer.parseInt(mes),  Integer.parseInt(anio) );

        return "La edad es: " + edad;
    }
}
