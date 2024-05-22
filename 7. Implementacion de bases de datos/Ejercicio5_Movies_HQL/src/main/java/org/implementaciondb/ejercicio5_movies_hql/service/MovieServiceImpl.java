package org.implementaciondb.ejercicio5_movies_hql.service;

import org.implementaciondb.ejercicio5_movies_hql.exception.NoFoundException;
import org.implementaciondb.ejercicio5_movies_hql.mapper.MovieMapper;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.MovieDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Movie;
import org.implementaciondb.ejercicio5_movies_hql.repository.IMovieRepository;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MovieDto> findMoviesWithActorsWithRatingGreaterThan(BigDecimal actorRating) {
        List<Movie> movies = movieRepository.findByActorsWithRatingGreaterThan(actorRating);
        return createListResponse(
                movies, "No se encontrarón películas con actores cuyo rating sea mayor a: " + actorRating
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovieDto> findMoviesWithGenre(Long genreId) {
        List<Movie> movies = movieRepository.findMoviesWithGenre(genreId);
        return createListResponse(
                movies, "No se encontrarón películas con el genero con el id: " + genreId
        );
    }

    private List<MovieDto> createListResponse(List<Movie> movies, String errorMessage) {
        if (movies.isEmpty()) {
            throw new NoFoundException(errorMessage);
        }
        return movies.stream()
                .map(MovieMapper::convertToDto)
                .toList();
    }
}
