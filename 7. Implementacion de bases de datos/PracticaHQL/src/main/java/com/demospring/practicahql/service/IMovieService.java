package com.demospring.practicahql.service;

import java.util.List;

public interface IMovieService {
    List<String> findMoviesByActorRatingOver(double rating);
    List<String> findMoviesByGenre(String genre);
}
