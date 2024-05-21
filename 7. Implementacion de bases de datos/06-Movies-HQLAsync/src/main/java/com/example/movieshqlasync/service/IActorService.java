package com.example.movieshqlasync.service;

import com.example.movieshqlasync.dto.response.ActorResponseDto;

import java.util.List;

public interface IActorService {
    List<ActorResponseDto> getActorsWithFavoriteMovie();
    List<ActorResponseDto> getActorsWithHighRating(Double rating);
    List<ActorResponseDto> getActorsByMovie(Integer movieId);
    ActorResponseDto getActorById(Integer id);
}
