package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.controller;

import lombok.AllArgsConstructor;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.MovieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.ActorService;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.IActorService;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.IMovieService;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IActorService actorService;
    @Autowired
    private IMovieService movieService;

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/actors")
    public ResponseEntity<List<MovieDto>> getAllMoviesActors(@RequestParam Double num) {
        return new ResponseEntity<>(actorService.getAllMoviesActorsByRating(num), HttpStatus.OK);
    }

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/genres")
    public ResponseEntity<List<MovieDto>> getAllMoviesGenres(@RequestParam String genres) {
        return new ResponseEntity<>(movieService.getAllMoviesGenres(genres), HttpStatus.OK);
    }


}
