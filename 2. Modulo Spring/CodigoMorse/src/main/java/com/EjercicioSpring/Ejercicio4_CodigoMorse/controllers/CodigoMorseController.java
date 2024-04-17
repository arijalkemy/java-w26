package com.EjercicioSpring.Ejercicio4_CodigoMorse.controllers;

import com.EjercicioSpring.Ejercicio4_CodigoMorse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {


    @Autowired
    ICodigoMorseService codigoMorseService;

    @GetMapping("/traducir/{dato}")
    public ResponseEntity<String> traducirEs(@PathVariable String dato) {
        if (dato.matches("[.\\s-]+")) {
            String palabra = codigoMorseService.getTextoDesdeMorse(dato);
            if (palabra == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uno de los simbolos no existe");
            }
            return ResponseEntity.status(HttpStatus.OK).body(palabra);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El dato ingresado no es valido");
        }
    }

    @GetMapping("/traducirMorse/{dato}")
    public ResponseEntity<String> traducirMorse(@PathVariable String dato) {
        String palabra = codigoMorseService.getMorseDesdeTexto(dato.toUpperCase());
        if (palabra == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uno de los simbolos no existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(palabra);
    }

}
