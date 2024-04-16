package com.meli.calcularedad_vivo.controller;

import com.meli.calcularedad_vivo.services.ICalcularEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcularEdad")
public class CalculadoraEdadController {

    @Autowired
    ICalcularEdad calcularEdad;

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable Integer dia,
                                @PathVariable Integer mes,
                                @PathVariable Integer anio) {
        return calcularEdad.calcularEdad(dia, mes, anio);

    }
}
