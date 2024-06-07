package com.mercadolibree.HQL_movies_db.controller;

import com.mercadolibree.HQL_movies_db.dto.MoviesResponseDto;
import com.mercadolibree.HQL_movies_db.repository.IMovieRepository;
import com.mercadolibree.HQL_movies_db.service.movie.IMoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    IMoviesService moviesService;

    MoviesController(IMoviesService _moviesService)
    {
        moviesService = _moviesService;
    }

    @GetMapping("/get/rating/{rating}")
    public ResponseEntity<List<MoviesResponseDto>> getMoviesByRating(@PathVariable Double rating)
    {
        return new ResponseEntity<>(
                moviesService.getMoviesByRating(rating),
                HttpStatus.OK
        );
    }

    @GetMapping("/get/genre/{genre}")
    public ResponseEntity<List<MoviesResponseDto>> getMoviesByGenre(@PathVariable String genre)
    {
        return new ResponseEntity<>(
                moviesService.getMoviesByGenre(genre),
                HttpStatus.OK
        );
    }

}
