package meli.bootcamp.movies.services;

import meli.bootcamp.movies.DTOs.MovieDTO;

import java.util.List;

public interface IMovieService {
    public List<MovieDTO> getPeliculasByActoresConRatingMayorQue(Double rating);
    public List<MovieDTO> getPeliculasByGenero(Long generoId);
    public List<String> getSeriesByTemporadasGreaterThan(Integer cantTemporadas);
    public List<String> getEpisodiosByActor(String actor);
}
