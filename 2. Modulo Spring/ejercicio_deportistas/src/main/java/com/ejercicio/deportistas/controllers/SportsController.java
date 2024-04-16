package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.models.Sport;
import com.ejercicio.deportistas.services.interfaces.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {
    @Autowired
    ISportsService sportsService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Sport> getAllSports() {
        return sportsService.getAllSports();
    }

    @GetMapping("/findSports/{name}")
    @ResponseBody
    public Sport getAllSports(@PathVariable String name) {
        return sportsService.getSportByName(name);
    }
}
