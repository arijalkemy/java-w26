package org.example.movies.service;

import org.example.movies.model.Actor;
import org.example.movies.model.dto.ActorResponseDTO;
import org.example.movies.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    IActorRepository actorRepository;

    ModelMapper mapper = new ModelMapper();

    public List<ActorResponseDTO> mapEntityToDTO(List<Actor> actors) {
        return actors.stream().map(actor -> mapper.map(actor, ActorResponseDTO.class)).toList();
    }

    @Override
    public List<ActorResponseDTO> findActorsWithFavoriteMovie() {
        List<Actor> listActors = actorRepository.findActorsByFavoriteMovie();
        return mapEntityToDTO(listActors);
    }

    @Override
    public List<ActorResponseDTO> findActorsWithRatingGreaterThan(Double rating) {
        List<Actor> listActors = actorRepository.findActorsByRatingGreaterThan(rating);
        return mapEntityToDTO(listActors);
    }

    @Override
    public List<ActorResponseDTO> findActorsByTitleMovie(String movie) {
        List<Actor> listActors = actorRepository.findActorsByMovie(movie);
        return mapEntityToDTO(listActors);
    }
}
