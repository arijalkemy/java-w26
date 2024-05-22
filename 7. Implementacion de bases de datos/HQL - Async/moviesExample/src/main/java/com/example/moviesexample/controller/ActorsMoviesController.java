package com.example.moviesexample.controller;

import com.example.moviesexample.entity.Movies;
import com.example.moviesexample.service.ActorsMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class ActorsMoviesController {

    @Autowired
    ActorsMovieService actorsMovieService;

    @GetMapping("/byRating/{number}")
    public List<Movies> getMoviesByRating(@PathVariable BigDecimal number) {
        return actorsMovieService.findMoviesByRating(number);
    }

    @GetMapping("/{genre}")
    public List<Movies> getMoviesByGenre(@PathVariable String genre) {
        return actorsMovieService.getMoviesByGenre(genre);
    }
}
