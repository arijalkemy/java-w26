package com.meli.obrasliterarias.controller;

import com.meli.obrasliterarias.dto.ObrasLiterariasDTO;
import com.meli.obrasliterarias.service.IObrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObrasController {
    @Autowired
    IObrasService obrasService;

    @PostMapping("/obras")
    ResponseEntity<?> createObra(@RequestBody ObrasLiterariasDTO obra){
        return ResponseEntity.status(HttpStatus.OK).body(obrasService.createObra(obra));

    }

    @GetMapping("/obrasByAutor")
    ResponseEntity<?> getObrasByAutor(@RequestParam String nombreDeAutor){
        return new ResponseEntity<>(obrasService.listObrasByAutor(nombreDeAutor),HttpStatus.OK );

    }


}
