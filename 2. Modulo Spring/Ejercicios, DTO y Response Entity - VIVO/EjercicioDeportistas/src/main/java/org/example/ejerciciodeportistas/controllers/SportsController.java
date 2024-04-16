package org.example.ejerciciodeportistas.controllers;

import org.example.ejerciciodeportistas.entities.PersonDTO;
import org.example.ejerciciodeportistas.entities.Sport;
import org.example.ejerciciodeportistas.services.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {

    @Autowired
    ISportsService sportsService;

    @GetMapping("/findSports")
    public List<Sport> findSports(){
       return sportsService.getSports();
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<String> findSportByName(@PathVariable String name){

        String level = sportsService.getSportByName(name);
        if (level != null){
            return new ResponseEntity<>( level,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<PersonDTO>> findSportsPersons(){
        return new ResponseEntity<>(sportsService.getSportsPersons(), HttpStatus.OK);
    }
}
