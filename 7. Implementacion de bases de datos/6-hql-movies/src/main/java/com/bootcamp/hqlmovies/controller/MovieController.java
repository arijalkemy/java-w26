package com.bootcamp.hqlmovies.controller;

import com.bootcamp.hqlmovies.model.dto.ActorDTO;
import com.bootcamp.hqlmovies.model.dto.MovieDTO;
import com.bootcamp.hqlmovies.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    private IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/withActorsRatingGt")
    public ResponseEntity<List<MovieDTO>> getMoviesWithActorsRatingGt(@RequestParam Double value){
        List<MovieDTO> movies = movieService.getAllMoviesWithActorsRatingGt(value);
        return ResponseEntity.ok(movies);
    }

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getMoviesWithGenre(@PathVariable String genre){
        List<MovieDTO> movies = movieService.getAllMoviesWithGenre(genre);
        return ResponseEntity.ok(movies);
    }
}
