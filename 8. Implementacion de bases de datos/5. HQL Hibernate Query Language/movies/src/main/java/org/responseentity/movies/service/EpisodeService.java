package org.responseentity.movies.service;

import org.responseentity.movies.dto.EpisodeDTO;
import org.responseentity.movies.model.Actor;
import org.responseentity.movies.model.Episode;
import org.responseentity.movies.repository.ActorRepository;
import org.responseentity.movies.repository.EpisodeRepository;
import org.responseentity.movies.service.Interface.IEpisodeService;
import org.responseentity.movies.utils.EpisodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {
    ActorRepository actorRepository;
    EpisodeRepository episodeRepository;

    public EpisodeService(
            @Autowired ActorRepository actorRepository,
            @Autowired EpisodeRepository episodeRepository
    ){
        this.actorRepository = actorRepository;
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDTO> listAllEpisodesByActor(String firstName, String lastName) {
        List<Episode> episodes = episodeRepository.listAllEpisodesByActor(firstName, lastName);
        return episodes.stream()
                .map(episode -> EpisodeMapper.entityToDto(episode))
                .collect(Collectors.toList());
    }
}
