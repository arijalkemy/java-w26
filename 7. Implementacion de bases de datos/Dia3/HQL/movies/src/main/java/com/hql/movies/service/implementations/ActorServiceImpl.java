package com.hql.movies.service.implementations;

import com.hql.movies.model.Actor;
import com.hql.movies.repository.IActorRepository;
import com.hql.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    IActorRepository actorRepository;

    @Override
    public List<Actor> findByFavoriteMovieIsNotNull() {
        return actorRepository.findByFavoriteMovieIsNotNull()
                .stream()
                .filter(actor -> actor.getFavoriteMovie() != null)
                .toList();
    }

    @Override
    public List<Actor> findActorByRatingGreaterThan(double rating) {
        return actorRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public List<Actor> findActorByMovie(int id) {
        return actorRepository.findByMoviesId(id);
    }
}
