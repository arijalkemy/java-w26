package com.w26.movies.demo.service.interfaces;

import java.util.List;

import com.w26.movies.demo.entity.Movie;


public interface IGenreService {
    public List<Movie> findMoviesByGenre(Integer id);
    
}
