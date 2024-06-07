package com.mercadolibree.HQL_movies_db.service.actor;

import com.mercadolibree.HQL_movies_db.dto.ActorsResponseDto;
import com.mercadolibree.HQL_movies_db.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    ModelMapper mapper;
    IActorRepository actorRepository;
    ActorService(IActorRepository _actorRepository)
    {
        mapper = new ModelMapper();
        actorRepository = _actorRepository;
    }

    @Override
    public List<ActorsResponseDto> getAllActors() {
        mapper = new ModelMapper();
        return actorRepository.findAllByMovieIdIsNotNull().stream()
                .map(actor -> mapper.map(actor, ActorsResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorsResponseDto> getActorsByMovie(String movie) {
        return actorRepository.findActorsByMovie(movie)
                .stream()
                .map(actor -> mapper.map(actor, ActorsResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorsResponseDto> getActorsByAwardsNumber(Double rating) {
        return actorRepository.findActorsByCustomAwards(rating)
                .stream()
                .map(actor -> mapper.map(actor, ActorsResponseDto.class))
                .collect(Collectors.toList());
    }
}
