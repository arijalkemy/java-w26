package com.example.moviesexample.service;

import com.example.moviesexample.entity.Movies;

import java.math.BigDecimal;
import java.util.List;

public interface IActorsMovieService {

    List<Movies> findMoviesByRating(BigDecimal rating);

    List<Movies> getMoviesByGenre(String genre);
}
