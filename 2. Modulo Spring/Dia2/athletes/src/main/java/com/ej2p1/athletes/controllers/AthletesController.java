package com.ej2p1.athletes.controllers;

import com.ej2p1.athletes.dto.SportPersonDTO;
import com.ej2p1.athletes.services.IAthleteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthletesController {

    @Autowired
    private IAthleteValidator athleteValidatorService;

    @GetMapping("/findSportsPersons")
    public List<SportPersonDTO> findAthletes() {
        return athleteValidatorService.findAthletes();
    }
}
