package com.bootcamp.arqrestvivo.controllers;

import com.bootcamp.arqrestvivo.services.IEdadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EdadController {

    private final IEdadService edadService;

    public EdadController(IEdadService edadService) {
        this.edadService = edadService;
    }


    @GetMapping("/{dia}/{mes}/{año}")
    public ResponseEntity<?> calcularEdad(@PathVariable() int dia, @PathVariable() int mes, @PathVariable int año){
        try {
        return new ResponseEntity<>(edadService.calcularEdad(dia,mes,año), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
