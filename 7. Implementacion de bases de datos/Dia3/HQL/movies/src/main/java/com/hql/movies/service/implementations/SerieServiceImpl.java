package com.hql.movies.service.implementations;

import com.hql.movies.model.Episode;
import com.hql.movies.model.Serie;
import com.hql.movies.repository.ISerieRepository;
import com.hql.movies.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {

    @Autowired
    ISerieRepository serieRepository;

    @Override
    public List<Serie> findSerieByAmountSeasonsGreaterThan(int seasons) {
        return serieRepository.findBySeasonsGreaterThan(seasons);
    }

    @Override
    public List<Episode> findEpisodeByActorId(int actorId) {
        return serieRepository.findByEpisodesActorId(actorId);
    }
}
