package com.mercadolibre.moviesHQL.service;

import com.mercadolibre.moviesHQL.model.entity.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> findAllByFavorite_movie_idIsNotEmpty();
    List<Actor> findAllByRatingGreaterThan(Double rating);
    List<Actor> findAllByWorkingInMovie(Integer movie);
}
