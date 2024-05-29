package com.w26.movies.demo.service.interfaces;

import java.util.List;

import com.w26.movies.demo.entity.Actor;

public interface IMovieService {
    public List<Actor> findActorsByMovie(Integer id);  
}
