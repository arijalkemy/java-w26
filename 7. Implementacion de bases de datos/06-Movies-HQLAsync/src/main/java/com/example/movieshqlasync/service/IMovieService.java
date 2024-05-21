package com.example.movieshqlasync.service;

import com.example.movieshqlasync.dto.response.MovieResponseDto;

import java.util.List;

public interface IMovieService {
    List<MovieResponseDto> findMoviesByActorRating(Double rating);
    List<MovieResponseDto> findMoviesByGenre(int genreId);
}
