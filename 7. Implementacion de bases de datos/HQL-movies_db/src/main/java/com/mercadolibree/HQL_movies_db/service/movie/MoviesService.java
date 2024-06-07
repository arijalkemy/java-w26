package com.mercadolibree.HQL_movies_db.service.movie;

import com.mercadolibree.HQL_movies_db.dto.MoviesResponseDto;
import com.mercadolibree.HQL_movies_db.repository.IActorRepository;
import com.mercadolibree.HQL_movies_db.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService {

    IMovieRepository moviesRepository;
    ModelMapper mapper;
    MoviesService(IMovieRepository _moviesRepository)
    {
        mapper = new ModelMapper();
        moviesRepository = _moviesRepository;
    }

    @Override
    public List<MoviesResponseDto> getMoviesByGenre(String genre) {
        return moviesRepository.getMoviesByGenre(genre)
                .stream()
                .map(movie -> mapper.map(movie, MoviesResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MoviesResponseDto> getMoviesByRating(Double rating) {
        return moviesRepository.getMoviesByRating(rating)
                .stream()
                .map(movie -> mapper.map(movie, MoviesResponseDto.class))
                .collect(Collectors.toList());
    }
}
