package org.miprimerproyecto.practicahql.service;

import java.util.List;

public interface ImovieService {
    List<String> findMoviesWithActorsRatingGreaterThan(Double rating);

    List<String> findMoviesByGenre(String genre);

}
