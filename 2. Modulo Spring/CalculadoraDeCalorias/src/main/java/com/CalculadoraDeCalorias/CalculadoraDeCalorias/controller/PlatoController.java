package com.CalculadoraDeCalorias.CalculadoraDeCalorias.controller;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.services.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    IPlatoService platoService;

    @GetMapping("/{nombre}")
    public ResponseEntity<?> obtenerCalorias(@PathVariable String nombre) {

        int calorias = platoService.obtenerPlato(nombre);
        return new ResponseEntity<>(calorias, HttpStatus.OK);

    }


}
