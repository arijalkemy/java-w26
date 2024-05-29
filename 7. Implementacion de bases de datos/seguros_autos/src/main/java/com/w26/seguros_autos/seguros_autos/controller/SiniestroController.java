package com.w26.seguros_autos.seguros_autos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.seguros_autos.seguros_autos.mediator.dto.PostSiniestro;
import com.w26.seguros_autos.seguros_autos.mediator.dto.SuccesfullyResponse;
import com.w26.seguros_autos.seguros_autos.service.ISiniestroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/siniestro")
public class SiniestroController {

    @Autowired
    ISiniestroService siniestroService;

    @PostMapping("/new/{id_vehiculo}")
    public ResponseEntity<?> createSiniestro(@PathVariable(name = "id_vehiculo") Long idVehiculo, @RequestBody PostSiniestro siniestro) {
        SuccesfullyResponse response = siniestroService.createSiniestro(idVehiculo, siniestro);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSiniestro() {
        SuccesfullyResponse response = siniestroService.retriveAllSiniestro();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
   
    
    
}
