package com.hql.movies.controller;

import com.hql.movies.model.Movie;
import com.hql.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies/")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @GetMapping("actorRating/{rating}")  //mejorar para que se vea el actor con ese rating mayor
    public List<Movie> findMovieByActorRatingGreaterThan(@PathVariable("rating") double rating) {
        return movieService.findMovieByActorRatingGreaterThan(rating);
    }

    @GetMapping("genre/{genre_id}")
    public List<Movie> findMovieByGenreId(@PathVariable("genre_id") Integer genreId) {
        return movieService.findMovieByGenreId(genreId);
    }
}
