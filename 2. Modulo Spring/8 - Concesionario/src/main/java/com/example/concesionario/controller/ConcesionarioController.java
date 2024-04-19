package com.example.concesionario.controller;

import com.example.concesionario.dto.VehiculoDTO;
import com.example.concesionario.service.ConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/vehicles/")
public class ConcesionarioController {

    @Autowired
    ConcesionarioService _service;

    @PostMapping
    public ResponseEntity<?> crearVehiculo(@RequestBody VehiculoDTO vehiculo){
        return _service.crearVehiculo(vehiculo);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        return _service.buscarTodos();
    }

    @GetMapping("/dates")
    public ResponseEntity<?> buscarPorFecha(@RequestParam Integer desde, @RequestParam Integer hasta){
        return _service.buscarPorFecha(desde, hasta);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> buscarPorPrecio(@RequestParam Integer desde, @RequestParam Integer hasta){
        return _service.buscarPorPrecio(desde, hasta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        return _service.buscarPorId(id);
    }
}
