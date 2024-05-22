package org.ggomezr.movies.application.service.interfaces;

import java.util.List;

public interface IMovieService {

    List<String> getAllMoviesWhoseActorsRatingIsGreaterThan(Float rating);
    List<String> getAllMoviesWithGenre(String genre);
}
