package com.mercadolibre.moviesHQL.service;

import com.mercadolibre.moviesHQL.model.entity.Episode;

import java.util.List;

public interface IEpisodeService {
    List<Episode> findAllByWorkingActorEquals(Integer actor);
}
