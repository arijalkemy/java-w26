package org.example.movieshql.service;

import org.example.movieshql.dto.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSerieByNumberOfSeasonsGratherThan(Double quantity);
}
