package org.implementaciondb.ejercicio5_movies_hql.controller;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.ActorDto;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.IActorService;
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
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorService actorService;

    /**
     * Consigna: 1
     * Listar todos los actores que tengan declarada una película favorita.
     */
    @GetMapping("/favorite-movie")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.findActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    /**
     * Consigna: 2
     * Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
     *
     * @param rating
     */
    @GetMapping("/rating/greater-than/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsWithRatingGreaterThan(@PathVariable BigDecimal rating) {
        return new ResponseEntity<>(actorService.findActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    /**
     * Consigna: 3
     * Listar todos los actores que trabajan en la <película recibida por parámetro>
     *
     * @param movieId
     */
    @GetMapping("/working-on-movie/{movie_id}")
    public ResponseEntity<List<ActorDto>> getActorsWorkingOnTheMovie(@PathVariable(name = "movie_id") Long movieId) {
        return new ResponseEntity<>(actorService.findActorsWorkingOnTheMovie(movieId), HttpStatus.OK);
    }

    /**
     * ----------------- Opcional ------------------
     * Listar los actores que han trabajado en más de una serie y que tengan una calificación mayor a 8
     * @param rating
     * @return
     */
    @GetMapping("/multiple-serie/rating/greater-than/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsWithMultipleSeriesAndRatingGreaterThan(
            @PathVariable(name = "rating") BigDecimal rating
    ) {
        return new ResponseEntity<>(
                actorService.findActorsWithMultipleSeriesAndRatingGreaterThan(rating),
                HttpStatus.OK
        );
    }

}
