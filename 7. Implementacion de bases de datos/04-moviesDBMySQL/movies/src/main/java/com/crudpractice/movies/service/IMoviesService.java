package com.crudpractice.movies.service;

import com.crudpractice.movies.dto.ActorDTO;
import com.crudpractice.movies.dto.EpisodeDTO;
import com.crudpractice.movies.dto.MovieDTO;
import com.crudpractice.movies.dto.SerieDTO;

import java.util.List;

public interface IMoviesService {
    List<ActorDTO> showActorsWithFavMovies();
    List<ActorDTO> showActorsWithRatingGreaterThan(Double rating);
    List<ActorDTO> showActorsThatAppearInMovie(String movie);
    List<MovieDTO> showMoviesByActorRating(Double rating);
    List<MovieDTO> showMoviesByGenre(String genre);
    List<SerieDTO> showSeriesBySeasons(int seasons);
    List<EpisodeDTO> showEpisodesByActors(String actor);
}
