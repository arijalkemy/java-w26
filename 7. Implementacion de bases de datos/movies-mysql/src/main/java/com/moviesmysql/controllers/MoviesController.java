package com.moviesmysql.controllers;

import com.moviesmysql.services.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

    private final IMovieService movieService;

    public MoviesController(IMovieService movieService) {
        this.movieService = movieService;
    }

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/peliculas/actores/ratingGreaterThan/{rating}")
    public ResponseEntity<?> getPeliculasByActoresRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(
                this.movieService.getPeliculasByActoresConRatingMayorQue(rating),
                HttpStatus.OK
        );
    }

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/peliculas/genero/{generoId}")
    public ResponseEntity<?> getPeliculasByGenero(@PathVariable Long generoId) {
        return new ResponseEntity<>(
                this.movieService.getPeliculasByGenero(generoId),
                HttpStatus.OK
        );
    }



}
