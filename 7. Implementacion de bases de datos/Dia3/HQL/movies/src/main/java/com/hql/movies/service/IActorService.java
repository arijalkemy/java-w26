package com.hql.movies.service;

import com.hql.movies.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> findByFavoriteMovieIsNotNull();
    List<Actor> findActorByRatingGreaterThan(double rating);
    List<Actor> findActorByMovie(int id);
}
