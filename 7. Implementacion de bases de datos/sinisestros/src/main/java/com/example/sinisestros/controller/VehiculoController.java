package com.example.sinisestros.controller;

import com.example.sinisestros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/listPatentes")
    public ResponseEntity<?> getAllPatentes(){
        return  ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getAllPatentes());
    }

    @GetMapping("/listPatentesMarcas")
    public ResponseEntity<?> getAllPatentesMarcas(){
        return  ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getAllPatentesYMarcas());
    }

    @GetMapping("/listPatentesMasDeCuatroRuedasAnioActual")
    public ResponseEntity<?> getPatentesMasDeCuatroRuedasAnioActual(){
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getPatentesMasDeCuatroRuedasAnioActual());
    }

}
