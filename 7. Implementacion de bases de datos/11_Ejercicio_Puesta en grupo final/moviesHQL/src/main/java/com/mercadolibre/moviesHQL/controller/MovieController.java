package com.mercadolibre.moviesHQL.controller;

import com.mercadolibre.moviesHQL.model.entity.Movie;
import com.mercadolibre.moviesHQL.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    IMoviesService moviesService;

    @GetMapping("/genres/{number}")
    public ResponseEntity<List<Movie>> findAllByGenresEquals(@PathVariable Integer number) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findAllByGenresEquals(number));
    }

    @GetMapping("/rating/{number}")
    public ResponseEntity<List<Movie>> findAllByActorsRatingGreaterThan(@PathVariable Double number) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findAllByActorsRatingGreaterThan(number));
    }
}
