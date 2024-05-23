package org.example.movieshql.service.imp;

import org.example.movieshql.dto.EpisodeDTO;
import org.example.movieshql.model.Episode;
import org.example.movieshql.repository.IEpisodeRepository;
import org.example.movieshql.service.IEpisodeService;
import org.example.movieshql.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {
    @Autowired
    IEpisodeRepository episodeRepository;

    @Override
    public List<EpisodeDTO> getEpisodesByActor(Integer id) {
        List<Episode> episodes = episodeRepository.findEpisodesByActorId(id);
        return ModelMapperUtil.entitiesListToDTOs(episodes, EpisodeDTO.class);
    }
}
