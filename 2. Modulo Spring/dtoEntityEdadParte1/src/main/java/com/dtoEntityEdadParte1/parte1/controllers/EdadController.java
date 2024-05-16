package com.dtoEntityEdadParte1.parte1.controllers;




import com.dtoEntityEdadParte1.parte1.services.interfaces.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EdadController {

    @Autowired
    IEdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int edad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){
        return edadService.calcularEdad(dia, mes, anio);
    }
}
