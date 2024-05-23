package com.example.movies.service;

import com.example.movies.dto.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getAutorsWithFavoriteMovie();
    List<ActorDTO> getAutorsWithRatingAfterThan(Double rating);
    List<ActorDTO> getActorActorByMovie(String tittle);
}
