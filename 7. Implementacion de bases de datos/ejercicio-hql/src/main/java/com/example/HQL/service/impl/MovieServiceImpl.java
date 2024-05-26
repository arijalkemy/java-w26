package com.example.HQL.service.impl;

import com.example.HQL.dto.response.MovieResponseDto;
import com.example.HQL.model.Genre;
import com.example.HQL.model.Movie;
import com.example.HQL.repository.IGenreRepository;
import com.example.HQL.repository.IMovieRepository;
import com.example.HQL.service.IMovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    private final IMovieRepository movieRepository;
    private final IGenreRepository genreRepository;
    private final ModelMapper mapper;

    public MovieServiceImpl(IMovieRepository movieRepository, IGenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Movie, MovieResponseDto>() {
            @Override
            protected void configure() {
                map().getGenre().setName(source.getGenre().getName());
            }
        });
        this.mapper = mapper;
    }

    @Override
    public List<MovieResponseDto> searchAllWithActorsWithRatingAbove(Double rating) {
        List<Movie> movies = movieRepository.findAllWithActorsWithRatingAbove(rating);
        return movies.stream().map(movie -> mapper.map(movie, MovieResponseDto.class)).toList();
    }

    @Override
    public List<MovieResponseDto> searchAllByGenre(String genreName) {
        Genre genre = genreRepository.findByName(genreName).orElseThrow();
        List<Movie> movies = movieRepository.findByGenre(genre);
        return movies.stream().map(movie -> mapper.map(movie, MovieResponseDto.class)).toList();
    }
}
