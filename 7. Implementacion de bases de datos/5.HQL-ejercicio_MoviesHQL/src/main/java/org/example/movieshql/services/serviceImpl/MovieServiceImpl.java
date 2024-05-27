package org.example.movieshql.services.serviceImpl;

import org.example.movieshql.DTO.MovieResponseDto;
import org.example.movieshql.repository.IMovieRepository;
import org.example.movieshql.services.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<MovieResponseDto> allMoviesByGenre(String genre) {
        return movieRepository.allMoviesByGenre(genre).stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDto.class))
                .toList();
    }

    @Override
    public List<MovieResponseDto> listMoviesWithActorsAboveRating(double rating) {
        return movieRepository.listMoviesWithActorsAboveRating(rating)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDto.class))
                .toList();
    }
}
