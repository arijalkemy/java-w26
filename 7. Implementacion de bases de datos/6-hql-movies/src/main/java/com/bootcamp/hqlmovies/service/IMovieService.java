package com.bootcamp.hqlmovies.service;

import com.bootcamp.hqlmovies.model.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getAllMoviesWithActorsRatingGt(Double rating);
    List<MovieDTO> getAllMoviesWithGenre(String genre);
}
