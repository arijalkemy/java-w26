package com.obteniendo.edad.controller;

import com.obteniendo.edad.service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EdadController {

    @Autowired
    private IEdadService edadService;

    @GetMapping("/{dia}/{mes}/{años}")
    public int fechaAEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer años){
        return edadService.convertirEdad(dia,mes,años);
    }

}
