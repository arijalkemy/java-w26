package org.example.movieshql.service.imp;

import org.example.movieshql.dto.MovieDTO;
import org.example.movieshql.model.Movie;
import org.example.movieshql.repository.IMovieRepository;
import org.example.movieshql.service.IMovieService;
import org.example.movieshql.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    @Override
    public List<MovieDTO> getMoviesByActorRating(Double rating) {
        List<Movie> movies = movieRepository.findMoviesByActorsRatingGreaterThan(rating);
        return ModelMapperUtil.entitiesListToDTOs(movies, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findByGenreName(genre);
        return ModelMapperUtil.entitiesListToDTOs(movies, MovieDTO.class);
    }
}
