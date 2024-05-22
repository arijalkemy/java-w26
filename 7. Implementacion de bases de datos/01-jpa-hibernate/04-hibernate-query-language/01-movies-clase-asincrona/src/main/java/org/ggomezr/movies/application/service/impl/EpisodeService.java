package org.ggomezr.movies.application.service.impl;

import org.ggomezr.movies.application.service.interfaces.IEpisodeService;
import org.ggomezr.movies.domain.repository.IEpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;

    public EpisodeService(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<String> getAllEpisodesWhereActorIsPresent(String actor) {
        return episodeRepository.findAllEpisodesWhereActorIsPresent(actor);
    }

    @Override
    public List<String> getAllEpisodesWhichRatingIsGreaterThan(Float rating) {
        return episodeRepository.findAllEpisodesWhichRatingIsGreaterThan(rating);
    }
}
