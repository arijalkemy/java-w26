package com.demospring.practicahql.service.impl;

import com.demospring.practicahql.repository.IMovieRepository;
import com.demospring.practicahql.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {
    private final IMovieRepository movieRepository;

    @Override
    public List<String> findMoviesByActorRatingOver(double rating) {
        return movieRepository.findMoviesByActorRatingOver(rating);
    }

    @Override
    public List<String> findMoviesByGenre(String genre) {
        return movieRepository.findMoviesByGenre(genre);
    }
}
