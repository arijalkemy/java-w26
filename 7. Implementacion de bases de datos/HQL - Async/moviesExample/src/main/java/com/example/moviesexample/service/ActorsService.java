package com.example.moviesexample.service;

import com.example.moviesexample.entity.Actors;
import com.example.moviesexample.entity.Movies;
import com.example.moviesexample.repository.ActorMovieRepository;
import com.example.moviesexample.repository.ActorsRepository;
import com.example.moviesexample.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService implements IActorsService{

    private final ActorsRepository actorsRepository;
    private final ActorMovieRepository actorMovieRepository;

    public ActorsService(ActorsRepository actorsRepository, MoviesRepository moviesRepository, ActorMovieRepository actorMovieRepository) {
        this.actorsRepository = actorsRepository;
        this.actorMovieRepository = actorMovieRepository;
    }


    @Override
    public List<?> actorsFavMovie() {
        Movies movies = new Movies();
        movies.setId("0");
        return actorsRepository.findActorsByFavoriteMovie();
    }

    @Override
    public List<Actors> actorsByRating(Long rating) {
        return actorsRepository.findActorsByRatingGreaterThan(rating);
    }

    @Override
    public List<Actors> actorsByMovieAppear(String movieName) {
        return actorMovieRepository.findActorsInMovie(movieName);
    }
}
