package org.example.movieshql.services.serviceImpl;

import org.example.movieshql.DTO.ActorResponseDto;
import org.example.movieshql.repository.IActorRepository;
import org.example.movieshql.services.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {
    @Autowired
    IActorRepository actorRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ActorResponseDto> allActorsWithFavoriteMovie() {
        return  actorRepository.allActorsWithFavoriteMovie().stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDto.class))
                .toList();
    }

    @Override
    public List<ActorResponseDto> allActorsWithRatingMostOf(double rating) {
        return  actorRepository.listActorsWithRatingAbove(rating).stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDto.class))
                .toList();
    }

    @Override
    public List<ActorResponseDto> allActorsByMovie(String movie_name) {
        return actorRepository.allActorsByMovie(movie_name).stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDto.class))
                .toList();
    }
}
