package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.controller;

import lombok.AllArgsConstructor;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.ActorFavoriteMovieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.ActorDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController{
    @Autowired
    private ActorService actorService;

    //Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/favorite/movies")
    public ResponseEntity<List<ActorFavoriteMovieDto>> getActorsFavoriteMovies() {
        return new ResponseEntity<>(actorService.findAllActorFavoriteMovie(), HttpStatus.OK);
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/ranking")
    public ResponseEntity<List<ActorDto>> getActorsRanking(@RequestParam Double num) {
        return new ResponseEntity<>(actorService.allActorsRanking(num), HttpStatus.OK);
    }

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/movies")
    public ResponseEntity<List<ActorDto>> getActorsMovies(@RequestParam String movies) {
        return new ResponseEntity<>(actorService.getAllActorsByMovie(movies), HttpStatus.OK);
    }


}
