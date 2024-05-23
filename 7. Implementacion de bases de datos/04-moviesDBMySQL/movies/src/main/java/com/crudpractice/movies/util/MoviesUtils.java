package com.crudpractice.movies.util;

import com.crudpractice.movies.dto.ActorDTO;
import com.crudpractice.movies.dto.EpisodeDTO;
import com.crudpractice.movies.dto.MovieDTO;
import com.crudpractice.movies.dto.SerieDTO;
import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Episode;
import com.crudpractice.movies.entity.Movie;
import com.crudpractice.movies.entity.Serie;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MoviesUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static List<ActorDTO> getActorsDTO(List<Actor> actors) {
        List<ActorDTO> actorsDTO = actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDTO.class))
                .collect(Collectors.toList());
        return actorsDTO;
    }

    public static List<MovieDTO> getMoviesDTO(List<Movie> movies) {
        List<MovieDTO> movieDTO = movies.stream()
                .map(movie -> mapper.convertValue(movie, MovieDTO.class))
                .collect(Collectors.toList());
        return movieDTO;
    }

    public static List<SerieDTO> getSeriesDTO(List<Serie> series) {
        List<SerieDTO> serieDTO = series.stream()
                .map(serie -> mapper.convertValue(serie, SerieDTO.class))
                .collect(Collectors.toList());
        return serieDTO;
    }

    public static List<EpisodeDTO> getEpisodesDTO(List<Episode> episodes) {
        List<EpisodeDTO> episodeDTO = episodes.stream()
                .map(ep -> mapper.convertValue(ep, EpisodeDTO.class))
                .collect(Collectors.toList());
        return episodeDTO;
    }
}
