package org.example.movieshql.service;

import org.example.movieshql.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDTO> getEpisodesByActor(Integer id);
}
