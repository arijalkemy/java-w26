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
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Optional<Sport>> getByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> getSportsPersons(){
        return new ResponseEntity<>(service.getSportsPersons(), HttpStatus.OK);
    }
}
