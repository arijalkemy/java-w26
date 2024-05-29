package com.w26.movies.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.movies.demo.service.interfaces.ISerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    ISerieService serieService;

   @GetMapping("/greater_than/{count_seasons}")
   public ResponseEntity<?> getSeriesGreaterThanCountSeasons(@PathVariable(name = "count_seasons") Integer countSeasons) {
        return ResponseEntity.ok().body(serieService.findByGreaterThanCountSeasons(countSeasons));
    }

   @GetMapping("/")
   public ResponseEntity<?> getAllSeries(/** Deberia ir paginación xd */) {
    return ResponseEntity.ok().body(serieService.findAll());   
}

    
}
