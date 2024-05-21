package com.example.movieshqlasync.service;

import com.example.movieshqlasync.dto.response.MovieResponseDto;
import com.example.movieshqlasync.model.Movie;
import com.example.movieshqlasync.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService{
    @Autowired
    IMovieRepository iMovieRepository;

    @Override
    public List<MovieResponseDto> findMoviesByActorRating(Double rating) {
        List<MovieResponseDto> movieResponseDtos = new ArrayList<>();

        for (Movie movie : iMovieRepository.findMoviesByActorRating(rating)){
            movieResponseDtos.add(new ModelMapper().map(movie, MovieResponseDto.class));
        }

        return movieResponseDtos;
    }

    @Override
    public List<MovieResponseDto> findMoviesByGenre(int genreId) {
        List<MovieResponseDto> movieResponseDtos = new ArrayList<>();

        for (Movie movie : iMovieRepository.findAllByGenreId(genreId)){
            movieResponseDtos.add(new ModelMapper().map(movie, MovieResponseDto.class));
        }

        return movieResponseDtos;
    }
}
