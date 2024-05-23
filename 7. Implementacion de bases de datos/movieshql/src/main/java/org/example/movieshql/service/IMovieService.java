package org.example.movieshql.service;

import org.example.movieshql.dto.ActorDTO;
import org.example.movieshql.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getMoviesByActorRating(Double rating);
    List<MovieDTO> getMoviesByGenre(String genre);

}
