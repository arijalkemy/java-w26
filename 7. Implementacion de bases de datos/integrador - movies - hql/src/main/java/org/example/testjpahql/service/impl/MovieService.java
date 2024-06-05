package org.example.testjpahql.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.testjpahql.entity.Actor;
import org.example.testjpahql.entity.Movie;
import org.example.testjpahql.entity.dto.MovieDTO;
import org.example.testjpahql.repository.IMovieRepository;
import org.example.testjpahql.service.IMovieService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {

    private final IMovieRepository movieRepository;
    private final ObjectMapper objectMapper;

    private MovieDTO mapEntity(Movie movie){
        return objectMapper.convertValue(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> getMovieWithActorRating(BigDecimal rating) {
        return movieRepository.getMoviesWithActorRating(rating).stream().map(this::mapEntity).toList();
    }

    @Override
    public List<MovieDTO> getMovieWithGenre(String name) {
        return movieRepository.getMoviesWithGenre(name).stream().map(this::mapEntity).toList();
    }
}
