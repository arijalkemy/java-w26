package com.demospring.practicahql.service.impl;

import com.demospring.practicahql.model.Actor;
import com.demospring.practicahql.repository.IActorRepository;
import com.demospring.practicahql.service.IActorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ActorService implements IActorService {
    private final IActorRepository actorRepository;

    @Override
    public List<String> findActorsWithOneFavoriteMovie() {
        return actorRepository.findActorsWithOneFavoriteMovie();
    }

    @Override
    public List<String> findActorsByRatingOver(double rating) {
        return actorRepository.findActorsByRatingOver(rating);
    }

    @Override
    public List<String> findActorsByMovieName(String title) {
        return actorRepository.findActorsByMovieName(title);
    }
}
