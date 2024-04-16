package com.meli.EjercicioDeportistas.controller;

import com.meli.EjercicioDeportistas.models.Sport;
import com.meli.EjercicioDeportistas.dto.SportPersonDTO;
import com.meli.EjercicioDeportistas.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    private ISportService service;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Sport> getByName(@PathVariable String name){
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> getSportsPersons(){
        return ResponseEntity.ok(service.getSportsPersons());
    }
}
