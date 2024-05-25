package com.example.demo.controller;

import com.example.demo.dto.response.PatenteDTO;
import com.example.demo.dto.response.PatenteMarcaDTO;
import com.example.demo.service.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoServiceImpl vehiculoService;

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculo(@PathVariable Long id) {
        Vehiculo vehiculo = vehiculoService.getVehiculoById(id);
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping
    public ResponseEntity<Void> createVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.saveVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
     */

    // Listar patentes de vehiculos
    @GetMapping("/patentes")
    public ResponseEntity<List<PatenteDTO>> listarPatentes() {
        List<PatenteDTO> patentes = vehiculoService.listarPatentes();
        return ResponseEntity.ok(patentes);
    }

    @GetMapping("/patentes_marcas")
    public ResponseEntity<List<PatenteMarcaDTO>> listarPatentesYMarcasOrdenadosPorAnio() {
        List<PatenteMarcaDTO> vehiculos = vehiculoService.listarPatenteYMarcaOrdenadosPorAnio();
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/anio_actual")
    public ResponseEntity<List<PatenteDTO>> listarPatentesParaVehiculosConRuedasYAnioActual() {
        List<PatenteDTO> vehiculos = vehiculoService.listarPatentesParaVehiculosConRuedasYAnioActual();
        return ResponseEntity.ok(vehiculos);
    }



}
