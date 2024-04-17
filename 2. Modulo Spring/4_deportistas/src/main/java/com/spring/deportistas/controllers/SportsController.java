package com.spring.deportistas.controllers;

import com.spring.deportistas.models.Person;
import com.spring.deportistas.models.Sport;
import com.spring.deportistas.models.dto.PersonSportDTO;
import com.spring.deportistas.services.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SportsController {

    private final ISportsService sportsService;

    @Autowired
    public SportsController(ISportsService sportsService) {
        this.sportsService = sportsService;
    }

    @GetMapping("/findSports")
    public List<Sport> getAllSports() {
        return sportsService.getAllSports();
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<Sport> getAllSports(@PathVariable String name) {
        return new ResponseEntity<>(sportsService.getSportByName(name), HttpStatus.OK);
    }

}
