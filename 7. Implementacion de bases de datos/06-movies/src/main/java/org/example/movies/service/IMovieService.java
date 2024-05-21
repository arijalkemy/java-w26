package org.example.movies.service;

import org.example.movies.model.dto.ActorResponseDTO;

import java.util.List;

public interface IMovieService {
    List<ActorResponseDTO> findActorsWithFavoriteMovie();
    List<ActorResponseDTO> findActorsWithRatingGreaterThan(Double rating);
    List<ActorResponseDTO> findActorsByTitleMovie(String movie);
}
