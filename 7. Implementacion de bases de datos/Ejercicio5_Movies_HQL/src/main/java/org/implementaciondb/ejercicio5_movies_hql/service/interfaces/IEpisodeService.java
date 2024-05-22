package org.implementaciondb.ejercicio5_movies_hql.service.interfaces;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDto> findEpisodesWithActor(Long actorId);

    List<EpisodeDto> getEpisodesBySerieAndActor(Long serieId, Long actorId);
}
