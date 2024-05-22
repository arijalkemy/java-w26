package com.example.moviesexample.service;

import com.example.moviesexample.entity.Movies;
import com.example.moviesexample.repository.ActorMovieRepository;
import com.example.moviesexample.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorsMovieService implements IActorsMovieService {

    private final ActorMovieRepository actorMovieRepository;
    private final MoviesRepository moviesRepository;

    public ActorsMovieService(ActorMovieRepository actorMovieRepository, MoviesRepository moviesRepository) {
        this.actorMovieRepository = actorMovieRepository;
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<Movies> findMoviesByRating(BigDecimal rating) {
        return actorMovieRepository.findMoviesByRating(rating);
    }

    @Override
    public List<Movies> getMoviesByGenre(String genre) {
        return moviesRepository.getMoviesByGenre(genre);
    }
}
