package com.w26.movies.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.movies.demo.entity.Actor;
import com.w26.movies.demo.entity.Movie;
import com.w26.movies.demo.repository.IMovieRepository;
import com.w26.movies.demo.service.interfaces.IMovieService;
@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    ObjectMapper objectMapper;
    
    @Override
    public List<Actor> findActorsByMovie(Integer id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        
        if (optionalMovie.isEmpty()) {
            throw new RuntimeException("No existe dicha movie");
        }
        
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //List<Actor> actorsPOJO = optionalMovie.get().getActor().stream().map(actor -> objectMapper.convertValue(actor, ActorDTO.class)).toList();
        
        //for (Actor actorDTO : actorsPOJO) {
            //actorDTO.getFavoriteMovie();    
        //}

        return optionalMovie.get().getActor();
    }
    
}
