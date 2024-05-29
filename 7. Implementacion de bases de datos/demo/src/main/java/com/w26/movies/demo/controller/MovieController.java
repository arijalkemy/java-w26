package com.w26.movies.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.movies.demo.service.interfaces.IGenreService;
import com.w26.movies.demo.service.interfaces.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @Autowired
    IGenreService genreService;


    @GetMapping("/{id}/actors")
    public ResponseEntity<?> getActorsByMovie(@PathVariable Integer id) {
        return ResponseEntity.ok().body(movieService.findActorsByMovie(id));
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable Integer id ) {
        return ResponseEntity.ok().body(genreService.findMoviesByGenre(id));
    }
    
    
}
