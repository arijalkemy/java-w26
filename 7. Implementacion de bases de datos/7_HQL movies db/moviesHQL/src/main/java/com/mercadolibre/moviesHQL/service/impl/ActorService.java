package com.mercadolibre.moviesHQL.service.impl;

import com.mercadolibre.moviesHQL.model.entity.Actor;
import com.mercadolibre.moviesHQL.repository.IActorRepository;
import com.mercadolibre.moviesHQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {
    @Autowired
    IActorRepository actorRepository;

    @Override
    public List<Actor> findAllByFavorite_movie_idIsNotEmpty() {
        return actorRepository.findAllByFavorite_movie_idIsNotEmpty();
    }

    @Override
    public List<Actor> findAllByRatingGreaterThan(Double rating) {
        return actorRepository.findAllByRatingGreaterThan(rating);
    }

    @Override
    public List<Actor> findAllByWorkingInMovie(Integer movie) {
        return actorRepository.findAllByWorkingInMovie(movie);
    }
}
