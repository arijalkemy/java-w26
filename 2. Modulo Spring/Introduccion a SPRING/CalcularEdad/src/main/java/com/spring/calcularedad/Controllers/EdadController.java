package com.spring.calcularedad.Controllers;

import com.spring.calcularedad.Services.CalculatorService.ICalculatorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class EdadController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<?> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
            if (dia <= 0 || mes <= 0 || mes > 12) {
                return ResponseEntity.badRequest().body("Los valores proporcionados no son válidos.");
            }

            int edad = calculatorService.calcularEdad(dia, mes ,anio);

            return ResponseEntity.ok(edad);
    }
}
