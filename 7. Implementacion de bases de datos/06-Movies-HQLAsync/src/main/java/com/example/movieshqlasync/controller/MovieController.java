package com.example.movieshqlasync.controller;

import com.example.movieshqlasync.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    IMovieService iMovieService;

    @GetMapping("/{rating}")
    public ResponseEntity<?> getMovieByActorRating(@PathVariable Double rating){
        return new ResponseEntity<>(iMovieService.findMoviesByActorRating(rating), HttpStatus.OK);
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable int genreId){
        return new ResponseEntity<>(iMovieService.findMoviesByGenre(genreId), HttpStatus.OK);
    }
}
