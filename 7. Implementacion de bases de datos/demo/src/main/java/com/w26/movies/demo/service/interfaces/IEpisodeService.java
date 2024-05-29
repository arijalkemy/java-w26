package com.w26.movies.demo.service.interfaces;

import java.util.List;

import com.w26.movies.demo.entity.Episode;

public interface IEpisodeService {
    List<Episode> findEpisodeByActor(Integer idActor);
}
