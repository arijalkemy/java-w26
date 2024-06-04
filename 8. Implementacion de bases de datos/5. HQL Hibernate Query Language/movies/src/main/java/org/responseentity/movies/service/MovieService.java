package org.responseentity.movies.service;

import org.responseentity.movies.dto.MovieDTO;
import org.responseentity.movies.model.Movie;
import org.responseentity.movies.repository.MovieRepository;
import org.responseentity.movies.service.Interface.IMovieService;
import org.responseentity.movies.utils.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    private MovieRepository movieRepository;

    public MovieService(@Autowired MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> listMoviesByGenre(String genre) {
        List<Movie> moviesByGenre = movieRepository.listAllMoviesByGenre(genre);
        return moviesByGenre.stream()
                .map(movie -> MovieMapper.entityToDto(movie))
                .collect(Collectors.toList());
    }
}
