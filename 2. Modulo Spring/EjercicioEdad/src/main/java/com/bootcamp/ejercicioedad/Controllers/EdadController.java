package com.bootcamp.ejercicioedad.Controllers;

import com.bootcamp.ejercicioedad.Interfaces.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    private ICalculator calculator;


    @GetMapping("/{dia}/{mes}/{anio}")
    public String CalcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return this.calculator.calcularEdad(dia,mes,anio);
    }
}
