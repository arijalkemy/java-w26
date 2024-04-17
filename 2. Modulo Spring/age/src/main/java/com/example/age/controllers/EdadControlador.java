package com.example.age.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.age.services.IEdadService;

@RestController
@RequestMapping("/edad")
public class EdadControlador {

    @Autowired
    private IEdadService service; 
    
    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return new ResponseEntity<>(service.calcularEdad(dia, mes, anio), HttpStatus.OK);
    }
}