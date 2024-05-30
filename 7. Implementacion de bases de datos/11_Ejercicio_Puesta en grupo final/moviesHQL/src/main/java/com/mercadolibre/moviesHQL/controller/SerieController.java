package com.mercadolibre.moviesHQL.controller;

import com.mercadolibre.moviesHQL.model.entity.Serie;
import com.mercadolibre.moviesHQL.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    ISerieService serieService;

    @GetMapping("/season/{number}")
    public ResponseEntity<List<Serie>> findAllByCountSeason(@PathVariable Integer number) {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.findAllByCountSeason(number));
    }
}
