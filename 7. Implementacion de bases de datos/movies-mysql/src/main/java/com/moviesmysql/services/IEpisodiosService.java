package com.moviesmysql.services;

import com.moviesmysql.DTOs.EpisodeDTO;

import java.util.List;

public interface IEpisodiosService {
    List<EpisodeDTO> getEpisodiosByActor(Long actorId);
}
