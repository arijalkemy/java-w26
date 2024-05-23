package org.ggomezr.movies.application.service.impl;

import org.ggomezr.movies.application.service.interfaces.ISerieService;
import org.ggomezr.movies.domain.repository.ISerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService{

    private final ISerieRepository serieRepository;

    public SerieService(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<String> getAllSeriesWithMoreThanSeasons(Integer seasons) {
        return serieRepository.findAllSeriesWithMoreThanSeasons(seasons);
    }

    @Override
    public List<String> findAllSeriesWhereTitleIs(String title) {
        return serieRepository.findAllSeriesWhereTitleIs(title);
    }
}
