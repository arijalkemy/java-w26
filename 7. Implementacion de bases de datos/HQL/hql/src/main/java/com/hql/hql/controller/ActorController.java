package com.hql.hql.controller;

import com.hql.hql.model.Actor;
import com.hql.hql.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movies/actor")
public class ActorController {


    private final IActorService actorService;

    @GetMapping("/{rating}")
    public ArrayList<Actor> getActorsGreaterThanRating(@PathVariable int rating) {
        return actorService.findActorByRatingGreaterThan(rating);
    }

    @GetMapping("/with-favourite-movie")
    public ArrayList<Actor> getActorsWithFavouriteMovie() {
        return actorService.findActorByFavoriteMovieNotNull();
    }

    @GetMapping("name/{title}")
    public ArrayList<Actor> getActorsFeaturedInMovieWithName(@PathVariable String title) {
        return actorService.findActorByMovieName(title);
    }
}
