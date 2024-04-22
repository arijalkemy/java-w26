package com.javabootcamp.consesionarioautos.controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.javabootcamp.consesionarioautos.dto.AutoDTO;
import com.javabootcamp.consesionarioautos.model.Auto;
import com.javabootcamp.consesionarioautos.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class AutoController {

    @Autowired
    AutoService autoService;


    @GetMapping("/api/vehicles")
    public ResponseEntity<List<AutoDTO>> getAllAutos(){
        return ResponseEntity.ok(autoService.getALlAutos());
    }

    @GetMapping("/api/vehicles/{id}")
    public ResponseEntity<AutoDTO> getAutoById(@PathVariable int id){
        return ResponseEntity.ok(autoService.getAutoById(id));
    }

    @GetMapping("/api/vehicles/dates")
    public ResponseEntity<List<AutoDTO>> getAutosByDate(){
        return ResponseEntity.ok(autoService.orderByDate());
    }

    @GetMapping("/api/vehicles/prices")
    public ResponseEntity<List<AutoDTO>> getAutosbyPrice(){
        return ResponseEntity.ok(autoService.orderByPrice());
    }

    // Post Methods
    @PostMapping("/api/vehicles")
    public ResponseEntity<String> saveAuto(@RequestBody Auto auto) throws FileNotFoundException {
        if(autoService.saveNewAuto(auto)){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Objeto creado");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo crear el objeto");
        }
    }
}
