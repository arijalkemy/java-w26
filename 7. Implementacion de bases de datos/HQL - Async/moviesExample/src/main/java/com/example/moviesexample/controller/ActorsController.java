package com.example.moviesexample.controller;

import com.example.moviesexample.entity.Actors;
import com.example.moviesexample.entity.dto.ActorsWithFavMovie;
import com.example.moviesexample.service.IActorsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActorsController {

    private final IActorsService actorsService;

    @GetMapping("/")
    public List<?> getFav(){
        return actorsService.actorsFavMovie();
    }

    @GetMapping("/rating/{number}")
    public List<Actors> getActorsByRating(@PathVariable Long number) {
        return actorsService.actorsByRating(number);
    }

    @GetMapping("/movie/{name}")
    public List<Actors> getActorsByRating(@PathVariable String name) {
        return actorsService.actorsByMovieAppear(name);
    }
}
