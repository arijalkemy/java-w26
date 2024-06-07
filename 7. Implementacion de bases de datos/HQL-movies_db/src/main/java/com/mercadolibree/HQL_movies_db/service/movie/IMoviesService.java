package com.mercadolibree.HQL_movies_db.service.movie;

import com.mercadolibree.HQL_movies_db.dto.MoviesResponseDto;

import java.util.List;

public interface IMoviesService {
    List<MoviesResponseDto> getMoviesByRating(Double rating);
    List<MoviesResponseDto> getMoviesByGenre(String genre);
}
