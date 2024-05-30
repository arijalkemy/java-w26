package com.mercadolibre.moviesHQL.service.impl;

import com.mercadolibre.moviesHQL.model.entity.Movie;
import com.mercadolibre.moviesHQL.repository.IMoviesRepository;
import com.mercadolibre.moviesHQL.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMoviesService {

    @Autowired
    IMoviesRepository moviesRepository;

    @Override
    public List<Movie> findAllByActorsRatingGreaterThan(Double rating) {
        return moviesRepository.findAllByActorsRatingGreaterThan(rating);
    }

    @Override
    public List<Movie> findAllByGenresEquals(Integer genres) {
        return moviesRepository.findAllByGenresEquals(genres);
    }
}
