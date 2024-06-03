package com.bootcamp.hqlmovies.service;

import com.bootcamp.hqlmovies.model.dto.ActorDTO;
import com.bootcamp.hqlmovies.model.dto.MovieDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getAllActorsWithAFavoriteMovie();
    List<ActorDTO> getAllActorsWithRatingGreaterThan(Double rating);
    List<ActorDTO> getAllActorsInMovie(String movieTitle);
}
