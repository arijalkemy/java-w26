package com.example.ejercicio_introduccion_a_spring_p2.controller;

import com.example.ejercicio_introduccion_a_spring_p2.service.IConversorDecimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/conversor"})
public class ConversorController {
    @Autowired
    private IConversorDecimalService conversor;

    @GetMapping("/{decimal}")
    public ResponseEntity<String> convertirDecimalRomano(
            @PathVariable Integer decimal
    ) {
        return new ResponseEntity<>(
                conversor.convertir(decimal),
                HttpStatus.OK
        );
    }
}
