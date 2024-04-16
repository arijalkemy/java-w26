package com.ejercicios.fechanacimiento.restcontroller;

import com.ejercicios.fechanacimiento.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadRestController {

    @Autowired
    private EdadService edadService;

    @GetMapping(path = "{dia}/{mes}/{anio}")
    public Integer calcularFecha(@PathVariable Integer dia,
                                 @PathVariable Integer mes,
                                 @PathVariable Integer anio){
        return edadService.calcularEdad(anio, mes, dia);
    }
}