package org.example.movieshql.services;

import org.example.movieshql.DTO.ActorResponseDto;

import java.util.List;

public interface IActorService {
    List<ActorResponseDto> allActorsWithFavoriteMovie();
    List<ActorResponseDto> allActorsWithRatingMostOf(double rating);
    List<ActorResponseDto> allActorsByMovie(String movie_name);
}
