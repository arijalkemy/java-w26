package meli.bootcamp.movies.services;

import meli.bootcamp.movies.DTOs.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSeriesByTemporadasGreaterThan(Integer cantTemporadas);
}
