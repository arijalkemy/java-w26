package com.moviesmysql.services.impl;

import com.moviesmysql.DTOs.ActorDTO;
import com.moviesmysql.Repositories.IActorRepository;
import com.moviesmysql.models.Actor;
import com.moviesmysql.services.IActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {
    private final IActorRepository actorRepository;

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> getActoresWithFavoriteMovie() {
        return this.convertListActorsToListActorsDTO(this.actorRepository.findByFavoriteMovieIsNotNull());
    }

    @Override
    public List<ActorDTO> getActoresWithRatingGreaterThan(Double rating) {
        return this.convertListActorsToListActorsDTO(this.actorRepository.findByRatingGreaterThan(rating));
    }

    @Override
    public List<ActorDTO> getActoresByPeliculaId(Long peliculaId) {
        return this.convertListActorsToListActorsDTO(this.actorRepository.findAllActorsByMovieId(peliculaId));
    }

    private List<ActorDTO> convertListActorsToListActorsDTO(List<Actor> actors) {
        return actors
                .stream()
                .map(actor -> new ActorDTO(
                        actor.getId(),
                        actor.getCreatedAt(),
                        actor.getUpdatedAt(),
                        actor.getFirstName(),
                        actor.getLastName(),
                        actor.getRating(),
                        actor.getFavoriteMovie() != null ? actor.getFavoriteMovie().getId() : null
                ))
                .toList();
    }
}
