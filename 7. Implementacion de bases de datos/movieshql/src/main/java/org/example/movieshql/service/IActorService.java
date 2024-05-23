package org.example.movieshql.service;

import org.example.movieshql.dto.ActorDTO;
import org.example.movieshql.dto.MovieDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsWithFavoriteMovie();
    List<ActorDTO> getActorsByHigherRating(Double rating);
    List<ActorDTO> getActorsByMovie(String title);
}

