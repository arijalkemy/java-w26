package org.example.testjpahql.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.testjpahql.entity.Actor;
import org.example.testjpahql.entity.dto.ActorDTO;
import org.example.testjpahql.repository.IActorRepository;
import org.example.testjpahql.service.IActorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService implements IActorService {

    private final IActorRepository actorRepository;
    private final ObjectMapper objectMapper;

    private ActorDTO mapToEntity(Actor actor){
        return objectMapper.convertValue(actor, ActorDTO.class);
    }

    @Override
    public List<ActorDTO> getActorsWithFavouriteMovie() {
        return actorRepository.findAllByFavouriteMovieIdNotNull().stream().map(this::mapToEntity).toList();
    }

    @Override
    public List<ActorDTO> getActorsWithRatingGreaterThan(BigDecimal rating) {
        return actorRepository.findAllByRatingGreaterThan(rating).stream().map(this::mapToEntity).toList();
    }

    @Override
    public List<ActorDTO> getActorsInMovie(String title) {
        return actorRepository.findActorsInMovie(title).stream().map(this::mapToEntity).toList();
    }
}
