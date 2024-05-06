package com.example._6_persona_practicatestyvalidaciones.controller;

import com.example._6_persona_practicatestyvalidaciones.dto.requestDTO.DeporteRequestDTO;
import com.example._6_persona_practicatestyvalidaciones.repository.IDeporteRepository;
import com.example._6_persona_practicatestyvalidaciones.service.IDeporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Sports")
public class DeporteController {
    @Autowired
    IDeporteService service;


    @PostMapping
    public ResponseEntity<?> agregarDeporte(@RequestBody @Valid DeporteRequestDTO deporteRequestDTO){
        return new ResponseEntity<>(service.agregarDeporte(deporteRequestDTO), HttpStatus.CREATED);
    }
}
