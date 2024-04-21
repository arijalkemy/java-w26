package org.example.ejercicio_edad.controllers;

import org.example.ejercicio_edad.services.IEdadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/edad")
public class EdadController {

    @Autowired
    IEdadServices edadServices;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Long> getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        try {
            return ResponseEntity.ok( edadServices.calcularEdad(dia,mes,anio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1L);
        }
    }
}
