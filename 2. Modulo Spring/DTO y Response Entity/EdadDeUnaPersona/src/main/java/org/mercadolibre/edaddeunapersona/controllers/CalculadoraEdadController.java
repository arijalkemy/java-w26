package org.mercadolibre.edaddeunapersona.controllers;

import org.mercadolibre.edaddeunapersona.services.CalculadoraEdadServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraEdadController {

    CalculadoraEdadServiceImpl calculadoraEdadService = new CalculadoraEdadServiceImpl();
    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return calculadoraEdadService.calcularEdad(dia, mes, anio);
    }
}
