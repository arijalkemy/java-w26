package com.numeros.romanos.controller;

import com.numeros.romanos.service.INumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @Autowired
    private INumerosRomanosService iNumerosRomanosService;

    @GetMapping("/{numero}")
    public ResponseEntity<String> getNumeroRomano(@PathVariable Integer numero) {

        if (numero < 1 || numero > 3999) {
            return ResponseEntity.badRequest().body("Número fuera de rango");
        }

        String numeroRomano = iNumerosRomanosService.getNumeroRomano(numero);

        return ResponseEntity.ok(numeroRomano);

    }
}
