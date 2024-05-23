package org.miprimerproyecto.practicahql.service.imp;

import org.miprimerproyecto.practicahql.repository.movieRepository;
import org.miprimerproyecto.practicahql.service.ImovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService implements ImovieService {

    @Autowired
    private movieRepository movieRepository;

    @Override
    public List<String> findMoviesWithActorsRatingGreaterThan(Double rating) {
        return movieRepository.findMoviesWithActorsRatingGreaterThan(rating);
    }

    @Override
    public List<String> findMoviesByGenre(String genre) {
        return movieRepository.findMoviesByGenre(genre);
    }
}
