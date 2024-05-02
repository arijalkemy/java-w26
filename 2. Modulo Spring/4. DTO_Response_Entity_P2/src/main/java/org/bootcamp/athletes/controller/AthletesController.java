package org.bootcamp.athletes.controller;

import org.bootcamp.athletes.service.IAthletesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AthletesController {
    @Autowired
    IAthletesService athletesService;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports() {
        return new ResponseEntity<>(athletesService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name) {
        return new ResponseEntity<>(athletesService.findSportByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        return new ResponseEntity<>(athletesService.findSportsPersons(), HttpStatus.OK);
    }
}
