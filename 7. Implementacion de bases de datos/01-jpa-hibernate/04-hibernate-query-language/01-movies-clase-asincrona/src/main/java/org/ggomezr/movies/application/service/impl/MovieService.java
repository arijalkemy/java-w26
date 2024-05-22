package org.ggomezr.movies.application.service.impl;

import org.ggomezr.movies.application.service.interfaces.IMovieService;
import org.ggomezr.movies.domain.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<String> getAllMoviesWhoseActorsRatingIsGreaterThan(Float rating) {
        return movieRepository.findAllMoviesWhoseActorsRatingIsGreaterThan(rating);
    }

    @Override
    public List<String> getAllMoviesWithGenre(String genre) {
        return movieRepository.findAllMoviesWithGenre(genre);
    }
}
