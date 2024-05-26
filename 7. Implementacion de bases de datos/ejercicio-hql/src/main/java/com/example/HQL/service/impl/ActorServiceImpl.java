package com.example.HQL.service.impl;

import com.example.HQL.dto.response.ActorResponseDto;
import com.example.HQL.model.Actor;
import com.example.HQL.model.Movie;
import com.example.HQL.repository.IActorRepository;
import com.example.HQL.repository.IMovieRepository;
import com.example.HQL.service.IActorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements IActorService {

    private final IActorRepository actorRepository;
    private final IMovieRepository movieRepository;

    @Override
    public List<ActorResponseDto> searchAllThatHaveFavoriteMovie() {
        ModelMapper mapper = new ModelMapper();
        List<Actor> actors = actorRepository.findAllActorsThatHaveFavoriteMovie();
        return actors
            .stream().map(actor -> mapper.map(actor, ActorResponseDto.class)).toList();
    }

    @Override
    public List<ActorResponseDto> searchAllWithRatingAbove(Integer rating) {
        ModelMapper mapper = new ModelMapper();
        List<Actor> actors = actorRepository.findAllActorsWithRatingAbove(rating);
        return actors
            .stream().map(actor -> mapper.map(actor, ActorResponseDto.class)).toList();
    }

    @Override
    public List<ActorResponseDto> searchAllWorkingInMovie(String title) {
        ModelMapper mapper = new ModelMapper();
        List<Actor> actors = actorRepository.findAllWorkingInMovie(title);
        return actors
            .stream().map(actor -> mapper.map(actor, ActorResponseDto.class)).toList();
    }
}
