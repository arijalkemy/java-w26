package com.w26.movies.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w26.movies.demo.entity.Episode;
import com.w26.movies.demo.repository.IActorEpisodeRepository;
import com.w26.movies.demo.service.interfaces.IEpisodeService;

@Service
public class EpisodeService implements IEpisodeService {
    @Autowired
    private IActorEpisodeRepository actorEpisodeRepository;

    @Override
    public List<Episode> findEpisodeByActor(Integer idActor) {
        System.out.println(actorEpisodeRepository.findByActorId(idActor));
        return actorEpisodeRepository.findByActorId(idActor);
    }

}
