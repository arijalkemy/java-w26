package com.EjercicioSpring.Ejercicio5_EdadPersona.controllers;

import com.EjercicioSpring.Ejercicio5_EdadPersona.service.ICalculadoraEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcularEdad")
public class CalculadoraEdadController {

    @Autowired
    ICalculadoraEdadService calculadoraEdadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdad(
            @PathVariable String dia, @PathVariable String mes, @PathVariable String anio
    ) {
        if (dia.matches("\\d+") && mes.matches("\\d+") && anio.matches("\\d+")) {
            String edad = calculadoraEdadService.getEdad(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anio));
            if (!edad.matches("\\d+")) {
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(edad);
            }
            return ResponseEntity.status(HttpStatus.OK).body(edad);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los valores de día, mes y año deberían ser numéricos y positivos");
        }
    }
}
