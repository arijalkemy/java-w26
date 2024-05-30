package com.mercadolibre.moviesHQL.service.impl;

import com.mercadolibre.moviesHQL.model.entity.Episode;
import com.mercadolibre.moviesHQL.repository.IEpisodeRepository;
import com.mercadolibre.moviesHQL.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {
    @Autowired
    IEpisodeRepository episodeRepository;

    @Override
    public List<Episode> findAllByWorkingActorEquals(Integer actor) {
        return episodeRepository.findAllByWorkingActorEquals(actor);
    }
}
