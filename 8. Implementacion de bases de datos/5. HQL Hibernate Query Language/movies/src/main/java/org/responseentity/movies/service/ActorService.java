package org.responseentity.movies.service;

import org.responseentity.movies.dto.ActorDTO;
import org.responseentity.movies.dto.ActorWithFavoriteMovieDTO;
import org.responseentity.movies.dto.MovieDTO;
import org.responseentity.movies.model.Actor;
import org.responseentity.movies.model.Movie;
import org.responseentity.movies.repository.ActorRepository;
import org.responseentity.movies.service.Interface.IActorService;
import org.responseentity.movies.utils.ActorMapper;
import org.responseentity.movies.utils.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    ActorRepository actorRepository;

    public ActorService(@Autowired ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorWithFavoriteMovieDTO> listAllActorsWithFavoriteMovie(){
        List<Actor> actorsWithFavoriteMovie = actorRepository.findAllActorsWithFavoriteMovie();
        return actorsWithFavoriteMovie.stream()
                .map(actor -> ActorMapper.entityToActorWithFavoriteMovie(actor))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> listAllActorsWithRating(Long rating) {
        List<Actor> actorsWithRating = actorRepository.findAllActorsWithRating(rating);
        return actorsWithRating.stream()
                .map(actor -> ActorMapper.entityToDto(actor))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> listAllActorsByMovie(String movie) {
        List<Actor> actorsByMovie = actorRepository.findAllActorsByMovie(movie);
        return actorsByMovie.stream()
                .map(actor -> ActorMapper.entityToDto(actor))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> listMoviesByActorsRating(Long rating) {
        List<Movie> moviesByActorsRating = actorRepository.findMoviesByActorsRating(rating);
        return moviesByActorsRating.stream()
                .map(movie -> MovieMapper.entityToDto(movie))
                .collect(Collectors.toList());
    }


}
