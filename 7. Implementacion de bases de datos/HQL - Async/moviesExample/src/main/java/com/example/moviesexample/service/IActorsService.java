package com.example.moviesexample.service;

import com.example.moviesexample.entity.Actors;
import com.example.moviesexample.entity.dto.ActorsWithFavMovie;

import java.util.List;

public interface IActorsService {
    List<?> actorsFavMovie();

    List<Actors> actorsByRating(Long rating);
    List<Actors> actorsByMovieAppear(String movieName);

}
