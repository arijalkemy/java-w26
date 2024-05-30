package com.mercadolibre.moviesHQL.service;

import com.mercadolibre.moviesHQL.model.entity.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> findAllByCountSeason(Integer cant_seasons);
}
