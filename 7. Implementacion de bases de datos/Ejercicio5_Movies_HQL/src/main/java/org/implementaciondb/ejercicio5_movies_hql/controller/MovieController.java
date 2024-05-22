package org.implementaciondb.ejercicio5_movies_hql.controller;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.MovieDto;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/actors/rating/greater-than/{actor_rating}")
    public ResponseEntity<List<MovieDto>> getMoviesWithActorsWithRatingGreaterThan(
            @PathVariable(name = "actor_rating") BigDecimal actorRating
    ) {
        return new ResponseEntity<>(
                movieService.findMoviesWithActorsWithRatingGreaterThan(actorRating), HttpStatus.OK
        );
    }


    @GetMapping("/genre/{genre_id}")
    public ResponseEntity<List<MovieDto>> getMoviesWithGenre(@PathVariable(name = "genre_id") Long genreId) {
        return new ResponseEntity<>(movieService.findMoviesWithGenre(genreId), HttpStatus.OK);
    }
}
