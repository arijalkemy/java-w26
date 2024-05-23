package com.moviesmysql.controllers;

import com.moviesmysql.services.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actores")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    // Listar todos los actores que tengan una película favorita
    @GetMapping("/with-favorite-movie")
    public ResponseEntity<?> getActoresWithFavoriteMovie() {
        return new ResponseEntity<>(
                this.actorService.getActoresWithFavoriteMovie(),
                HttpStatus.OK
        );
    }

    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/ratingGreaterThan/{rating}")
    public ResponseEntity<?> getActoresWithRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(
                this.actorService.getActoresWithRatingGreaterThan(rating),
                HttpStatus.OK
        );
    }

    // Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/pelicula/{peliculaId}")
    public ResponseEntity<?> getActoresByPeliculaId(@PathVariable Long peliculaId) {
        return new ResponseEntity<>(
                this.actorService.getActoresByPeliculaId(peliculaId),
                HttpStatus.OK
        );
    }

}
