package org.implementaciondb.ejercicio5_movies_hql.service;

import org.implementaciondb.ejercicio5_movies_hql.exception.NoFoundException;
import org.implementaciondb.ejercicio5_movies_hql.mapper.EpisodeMapper;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.EpisodeDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Episode;
import org.implementaciondb.ejercicio5_movies_hql.repository.IEpisodeRepository;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    @Autowired
    private IEpisodeRepository episodeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EpisodeDto> findEpisodesWithActor(Long actorId) {
        List<Episode> episodes = episodeRepository.findByActor(actorId);
        return createListResponse(episodes, "No hay episodios registrados con el actor de id: " + actorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EpisodeDto> getEpisodesBySerieAndActor(Long serieId, Long actorId) {
        List<Episode> episodes = episodeRepository.findByActor(actorId);
        return createListResponse(episodes, "No hay episodios registrados con esas características");
    }

    private List<EpisodeDto> createListResponse(List<Episode> episodes, String messageError) {
        if (episodes.isEmpty()) {
            throw new NoFoundException(messageError);
        }
        return episodes
                .stream()
                .map(EpisodeMapper::convertToDto)
                .toList();
    }

}
