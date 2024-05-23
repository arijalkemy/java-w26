package org.ggomezr.movies.application.service.impl;

import org.ggomezr.movies.application.service.interfaces.IActorService;
import org.ggomezr.movies.domain.repository.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private final IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<String> getAllActorsWithFavoriteMovie() {
        return actorRepository.findAllActorsWithFavoriteMovie();
    }

    @Override
    public List<String> findAllActorsWithRatingGreaterThan(Float rating) {
        return actorRepository.findAllActorsWithRatingGreaterThan(rating);
    }

    @Override
    public List<String> findAllActorsWhoWorkInTheMovie(String movieTitle) {
        return actorRepository.findAllActorsWhoWorkInTheMovie(movieTitle);
    }
}
