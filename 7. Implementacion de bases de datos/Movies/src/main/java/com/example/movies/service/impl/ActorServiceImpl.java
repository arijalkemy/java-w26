package com.example.movies.service.impl;

import com.example.movies.dto.ActorDTO;
import com.example.movies.model.Actors;
import com.example.movies.repository.ActorRepository;
import com.example.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService {
    @Autowired
    ActorRepository actorRepository;

    @Override
    public List<ActorDTO> getAutorsWithFavoriteMovie() {
        List<Actors> actors = actorRepository.findAllByFavoriteMovieIsNotNull();
        return actors.stream().map(this::actorToActorDTO).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getAutorsWithRatingAfterThan(Double rating) {
        List<Actors> actors = actorRepository.findActorsByRatingAfter(rating);
        return actors.stream().map(this::actorToActorDTO).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorActorByMovie(String tittle) {
        List<Actors> actors = actorRepository.findActorByMovieQuery(tittle);
        return actors.stream().map(this::actorToActorDTO).collect(Collectors.toList());
    }

    public ActorDTO actorToActorDTO(Actors actor){
        String tittle = "";
        if (actor.getFavoriteMovie()==null){
            tittle = null;
        }else{
            tittle = actor.getFavoriteMovie().getTitle();
        }
        return ActorDTO.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .rating(actor.getRating())
                .favoriteMovie(tittle)
                .build();
    }
}
