package org.example.movieshql.service.imp;

import org.example.movieshql.dto.ActorDTO;
import org.example.movieshql.model.Actor;
import org.example.movieshql.repository.IActorRepository;
import org.example.movieshql.service.IActorService;
import org.example.movieshql.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired
    IActorRepository actorRepository;

    @Override
    public List<ActorDTO> getActorsWithFavoriteMovie() {
        List<Actor> actors = actorRepository.findActorsWithFavoriteMovie();
        return actorsToDTOs(actors);
    }

    @Override
    public List<ActorDTO> getActorsByHigherRating(Double rating) {
        List<Actor> actors = actorRepository.findActorsWithHigherRating(rating);
        return actorsToDTOs(actors);
    }

    @Override
    public List<ActorDTO> getActorsByMovie(String title) {
        List<Actor> actors = actorRepository.findActorsByMovieNameContains(title);
        return actorsToDTOs(actors);
    }

    private List<ActorDTO> actorsToDTOs(List<Actor> actors){
        return ModelMapperUtil.entitiesListToDTOs(actors, ActorDTO.class);
    }

}
