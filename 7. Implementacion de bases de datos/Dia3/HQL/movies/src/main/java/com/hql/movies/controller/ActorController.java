package com.hql.movies.controller;

import com.hql.movies.model.Actor;
import com.hql.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors/")
public class ActorController {

    @Autowired
    IActorService actorService;

    @GetMapping("notNullFavMovie")
    public List<Actor> actorsWithFavoriteMovie() {
        return actorService.findByFavoriteMovieIsNotNull();
    }

    @GetMapping("/rating/{rating}")
    public List<Actor> findActorByRatingGreaterThan(@PathVariable("rating") double rating) {
        return actorService.findActorByRatingGreaterThan(rating);
    }

    @GetMapping("movie/{id}")  //hacer que se vea que pelicula es
    public List<Actor> findActorByMovieId(@PathVariable("id") int id) {
        return actorService.findActorByMovie(id);
    }


}
