package com.mercadolibre.moviesHQL.service.impl;

import com.mercadolibre.moviesHQL.model.entity.Serie;
import com.mercadolibre.moviesHQL.repository.ISerieRepository;
import com.mercadolibre.moviesHQL.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {
    @Autowired
    ISerieRepository serieRepository;
    @Override
    public List<Serie> findAllByCountSeason(Integer cant_seasons) {
        return serieRepository.findAllByCountSeason(cant_seasons);
    }
}
