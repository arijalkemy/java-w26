package org.example.integradordeportistas.controller;

import org.example.integradordeportistas.dto.SportsPersonDTO;
import org.example.integradordeportistas.model.Sport;
import org.example.integradordeportistas.service.impl.SportsPersonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsPersonController {

    private final SportsPersonImpl sportsPersonImpl;

    @Autowired
    public SportsPersonController(SportsPersonImpl sportsPersonImpl){
        this.sportsPersonImpl = sportsPersonImpl;
    }

    @GetMapping("/sports/findSports/")
    @ResponseBody
    public List<Sport> findSports(){
        return sportsPersonImpl.findAll();
    }

    @GetMapping("/sports/findSport/{name}")
    @ResponseBody
    public Sport findSport(@PathVariable String name){
        return sportsPersonImpl.find(name);
    }

    @GetMapping("/sports/findSportsPersons/")
    @ResponseBody
    public List<SportsPersonDTO> findSportsPersons(){
        return sportsPersonImpl.findRelated();
    }






}
