package org.example.movieshql.services;

import org.example.movieshql.DTO.MovieResponseDto;

import java.util.List;

public interface IMovieService{
    List<MovieResponseDto> allMoviesByGenre(String genre);
    List<MovieResponseDto> listMoviesWithActorsAboveRating(double movie);
}
