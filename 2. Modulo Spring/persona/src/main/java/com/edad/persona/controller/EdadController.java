package com.edad.persona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
public class EdadController {

    @GetMapping (path = "/{dia}/{mes}/{anio}")
    public String calcularEdad (@PathVariable int dia,
                                @PathVariable int mes,
                                @PathVariable int anio){

        LocalDate nacimiento = LocalDate.of(anio, mes, dia);

        LocalDate fechaActual = LocalDate.now();
        if(!nacimiento.isBefore(fechaActual)) {
            return "La fecha no debe ser mayor o igual a la fecha actual";
        }
        String edad = String.valueOf(ChronoUnit.YEARS.between(nacimiento, fechaActual));

        return edad ;

    }




}
