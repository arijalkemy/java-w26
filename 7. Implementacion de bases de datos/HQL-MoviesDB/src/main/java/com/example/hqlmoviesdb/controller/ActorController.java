package com.example.hqlmoviesdb.controller;

import com.example.hqlmoviesdb.model.Actor;
import com.example.hqlmoviesdb.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping ("/actors/favorite-movies")
    public List<String> actorsWithFavoriteMovie(){
        return actorService.findAllActorsWithFavorite();
    }

    @GetMapping ("/actors/{rating}")
    public List<String> actorsWithRatingGreaterThan(@PathVariable Double rating){
        return actorService.findActorsByRating(rating);
    }

    @GetMapping("/actors/movie/{movie}")
    public List<String> actorsWorksInMovie(@PathVariable String movie){
        return actorService.findActorsByWorkMovie(movie);
    }

    @GetMapping("/by-actor-rating/{rating}")
    public List<String> getMoviesByActorRating(@PathVariable Double rating){
        return actorService.findMoviesByActorsRating(rating);
    }

    @GetMapping("/by-genre")
    public List<String> getMoviesByGenre(@RequestParam String genre){
        return actorService.findMoviesByGenre(genre);
    }

    @GetMapping("series/seasons")
    public List<String> getSeriesBySeasons(@RequestParam int seasons){
        return actorService.findSeriesBySeasons(seasons);
    }

    @GetMapping("/episodes/by-actor")
    public List<String> getEpisodesByActor(@RequestParam String name,
                                           @RequestParam String lastName){
        return actorService.findEpisodesByActor(name, lastName);
    }



}
