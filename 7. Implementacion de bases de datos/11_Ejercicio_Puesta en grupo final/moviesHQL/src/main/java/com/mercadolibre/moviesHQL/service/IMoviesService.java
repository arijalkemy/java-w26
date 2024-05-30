package com.mercadolibre.moviesHQL.service;

import com.mercadolibre.moviesHQL.model.entity.Movie;

import java.util.List;

public interface IMoviesService {
    List<Movie> findAllByActorsRatingGreaterThan(Double rating);
    List<Movie> findAllByGenresEquals(Integer genres);
}
