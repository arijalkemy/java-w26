package com.EjercicioSpring.Ejercicio3_NumerosRomanos.controllers;

import com.EjercicioSpring.Ejercicio3_NumerosRomanos.service.RomanNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class RomanNumbersController {

    @Autowired
    RomanNumbersService romanNumbersService;

    @GetMapping("translateNumber/{number}")
    public ResponseEntity<String> translateNumber(@PathVariable String number) {
        if (number != null && number.matches("-?\\d+")) {
            int x = Integer.parseInt(number);
            if (x == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número 0 no es soportado");
            }
            return ResponseEntity.status(HttpStatus.OK).body(romanNumbersService.convertDecimalToRoman(x));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El valor dado no es valido");
        }
    }

}
