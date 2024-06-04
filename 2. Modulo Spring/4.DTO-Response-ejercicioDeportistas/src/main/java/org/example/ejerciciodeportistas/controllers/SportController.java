package org.example.ejerciciodeportistas.controllers;

import org.example.ejerciciodeportistas.services.IsportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SportController {

    @Autowired
    IsportServices isportServices;

    @GetMapping("/findSports")
    public ResponseEntity<?> getSports() {
        return new ResponseEntity<>(isportServices.allSporst(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getSport(@PathVariable String name) {
        return new ResponseEntity<>(isportServices.sportByName(name), HttpStatus.OK);
    }

}
