package com.example.consultashql.controller;

import com.example.consultashql.entity.Vehiculo;
import com.example.consultashql.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Vehiculo vehiculo){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.save(vehiculo));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getAll());
    }

    @GetMapping("/patente")
    public ResponseEntity<?> getAllPatante(){
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getPatente());
    }

    @GetMapping("/marca")
    public ResponseEntity<?> getPantenteAndMarca(){
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getPatenteAndMarca());
    }



}
