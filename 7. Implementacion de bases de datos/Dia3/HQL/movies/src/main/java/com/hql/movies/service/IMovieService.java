package com.hql.movies.service;

import com.hql.movies.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findMovieByActorRatingGreaterThan(double actorRating);
    List<Movie> findMovieByGenreId(Integer genreId);
}
