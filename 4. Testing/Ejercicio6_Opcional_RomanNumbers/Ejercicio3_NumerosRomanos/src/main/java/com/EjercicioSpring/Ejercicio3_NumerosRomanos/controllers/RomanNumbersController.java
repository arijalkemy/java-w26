package com.EjercicioSpring.Ejercicio3_NumerosRomanos.controllers;

import com.EjercicioSpring.Ejercicio3_NumerosRomanos.service.RomanNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumbersController {

    @Autowired
    RomanNumbersService romanNumbersService;

    @GetMapping("translateNumber/{number}")
    public ResponseEntity<String> translateNumber(@PathVariable Integer number) {
        return ResponseEntity.status(HttpStatus.OK).body(romanNumbersService.convertDecimalToRoman(number));
    }

}
