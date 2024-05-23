package com.moviesmysql.services;

import com.moviesmysql.DTOs.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSeriesByTemporadasGreaterThan(Integer cantTemporadas);
}
