package meli.bootcamp.movies.services;

import meli.bootcamp.movies.DTOs.EpisodeDTO;

import java.util.List;

public interface IEpisodiosService {
    List<EpisodeDTO> getEpisodiosByActor(Long actorId);
}
