package com.hql.movies.service.implementations;

import com.hql.movies.model.Movie;
import com.hql.movies.repository.IMovieRepository;
import com.hql.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    IMovieRepository movieRepository;

    @Override
    public List<Movie> findMovieByActorRatingGreaterThan(double actorRating) {
        return movieRepository.findByActorsRatingGreaterThan(actorRating);
    }

    @Override
    public List<Movie> findMovieByGenreId(Integer genreId) {
        return movieRepository.findByGenreId(genreId);
    }
}
