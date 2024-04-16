package com.mercadolibre.ejerciciodeportistas.controller;

import com.mercadolibre.ejerciciodeportistas.model.entity.Person;
import com.mercadolibre.ejerciciodeportistas.model.entity.Sport;
import com.mercadolibre.ejerciciodeportistas.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sport")
public class SportController {
    @Autowired
    private ISportService sportService;

    @GetMapping(path = "findSports")
    public ResponseEntity<List<Sport>> findSports() {
        return ResponseEntity.ok(sportService.findAll());
    }

    @GetMapping(path = "findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        return ResponseEntity.ok(sportService.findLevelByName(name));
    }

}
