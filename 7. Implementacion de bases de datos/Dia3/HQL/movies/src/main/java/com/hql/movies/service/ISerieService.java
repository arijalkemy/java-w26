package com.hql.movies.service;

import com.hql.movies.model.Episode;
import com.hql.movies.model.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> findSerieByAmountSeasonsGreaterThan(int seasons);
    List<Episode> findEpisodeByActorId(int actorId);
}
