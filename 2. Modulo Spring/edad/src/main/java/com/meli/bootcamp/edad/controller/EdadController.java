package com.meli.bootcamp.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    // Aquí, la URL tiene tres partes variables: {dia}, {mes}, {anio} que serán proporcionadas por el usuario.
    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        // Calcula el periodo entre la fecha de nacimiento y la fecha actual.
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        // Devuelve la edad calculada en años, como una cadena de texto.
        return "Edad: " + periodo.getYears() + " años";
    }
}
