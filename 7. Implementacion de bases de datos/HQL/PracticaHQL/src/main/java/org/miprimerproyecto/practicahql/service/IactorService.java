package org.miprimerproyecto.practicahql.service;

import java.util.List;

public interface IactorService {
    List<String> findActorsWithFavoriteMovie();
    List<String> findActorsWithRatingGreaterThan(Double rating);
    List<String> findActorsByMovieTitle(String title);
}
