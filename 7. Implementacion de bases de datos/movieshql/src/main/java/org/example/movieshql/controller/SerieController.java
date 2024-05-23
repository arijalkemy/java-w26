package org.example.movieshql.controller;

import org.example.movieshql.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    ISerieService serieService;

    @GetMapping("/number-of-seasons")
    ResponseEntity<?> retrieveSeriesByNumberOfSeason(@RequestParam Double seasons){
        return ResponseEntity.ok(serieService.getSerieByNumberOfSeasonsGratherThan(seasons));
    }
}
