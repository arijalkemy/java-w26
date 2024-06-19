package org.bootcamp.calculadoraedad.controller;

import org.bootcamp.calculadoraedad.service.CalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController
{
    private CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService){
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<?> calcularEdad(@PathVariable("dia")Integer dia,
                                          @PathVariable("mes")Integer mes,
                                          @PathVariable("anio")Integer anio){
        return new ResponseEntity<>(calculadoraService.calcularEdad(dia,mes,anio),
                HttpStatus.OK);
    }
}
