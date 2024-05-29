package com.w26.movies.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.movies.demo.repository.IGenreRepository;
import com.w26.movies.demo.service.interfaces.IGenreService;
import com.w26.movies.demo.entity.Genre;
import com.w26.movies.demo.entity.Movie;

@Service
public class GenreService implements IGenreService {

    @Autowired
    IGenreRepository genreRepository;

    @Autowired
    ObjectMapper objectMapper;
    
    @Override
    public List<Movie> findMoviesByGenre(Integer id) {
        Optional<Genre> genreOptional = genreRepository.findById(id);   

        if (genreOptional.isEmpty()) {
            throw new RuntimeException("Not fount genre");
        }

        Genre genre = genreOptional.get();

        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //List<Movie> moviesPOJO = genre.getMovies().stream().map(m -> objectMapper.convertValue(m, MovieDTO.class)).toList();

        return genre.getMovies();
    }
    
}
