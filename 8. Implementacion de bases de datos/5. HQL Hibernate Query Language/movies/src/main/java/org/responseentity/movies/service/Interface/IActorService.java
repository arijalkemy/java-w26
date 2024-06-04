package org.responseentity.movies.service.Interface;

import org.responseentity.movies.dto.ActorDTO;
import org.responseentity.movies.dto.ActorWithFavoriteMovieDTO;
import org.responseentity.movies.dto.MovieDTO;

import java.util.List;

public interface IActorService {
    List<ActorWithFavoriteMovieDTO> listAllActorsWithFavoriteMovie();
    List<ActorDTO> listAllActorsWithRating(Long rating);
    List<ActorDTO> listAllActorsByMovie(String movie);
    List<MovieDTO> listMoviesByActorsRating(Long rating);
}
