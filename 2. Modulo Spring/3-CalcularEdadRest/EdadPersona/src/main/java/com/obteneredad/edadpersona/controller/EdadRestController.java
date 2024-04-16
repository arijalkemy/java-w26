package com.obteneredad.edadpersona.controller;

import com.obteneredad.edadpersona.service.IEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadRestController {

    @Autowired
    IEdad CalcularEdad;

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano){
        return CalcularEdad.calcularEdad(dia, mes, ano);
    }

}
