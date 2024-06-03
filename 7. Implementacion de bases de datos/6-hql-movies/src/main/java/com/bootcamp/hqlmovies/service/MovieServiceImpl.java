package com.bootcamp.hqlmovies.service;

import com.bootcamp.hqlmovies.model.Movie;
import com.bootcamp.hqlmovies.model.dto.MovieDTO;
import com.bootcamp.hqlmovies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    private final ModelMapper mapper = new ModelMapper();
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private List<MovieDTO> mapMovieEntityToDTO(List<Movie> movies) {
        return movies.stream().map(
                m -> mapper.map(m, MovieDTO.class)
        ).toList();
    }

    @Override
    public List<MovieDTO> getAllMoviesWithActorsRatingGt(Double rating) {
        return mapMovieEntityToDTO(movieRepository.findMovieWithActorsWithRatingGt(rating));
    }

    @Override
    public List<MovieDTO> getAllMoviesWithGenre(String genre) {
        return mapMovieEntityToDTO(movieRepository.findAllByGenreName(genre));
    }
}
