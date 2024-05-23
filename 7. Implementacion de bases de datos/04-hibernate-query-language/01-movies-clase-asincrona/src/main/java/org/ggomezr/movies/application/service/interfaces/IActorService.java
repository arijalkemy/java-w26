package org.ggomezr.movies.application.service.interfaces;

import java.util.List;

public interface IActorService {
    List<String> getAllActorsWithFavoriteMovie();
    List<String> findAllActorsWithRatingGreaterThan(Float rating);
    List<String> findAllActorsWhoWorkInTheMovie(String movieTitle);
}
