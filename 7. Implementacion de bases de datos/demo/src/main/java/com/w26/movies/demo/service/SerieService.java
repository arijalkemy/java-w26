package com.w26.movies.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w26.movies.demo.entity.Serie;
import com.w26.movies.demo.repository.ISeasonRepository;
import com.w26.movies.demo.repository.ISerieRepository;
import com.w26.movies.demo.service.interfaces.ISerieService;

@Service
public class SerieService implements ISerieService {

    @Autowired
    ISeasonRepository seasonRepository;

    @Autowired
    ISerieRepository serieRepository;

    @Override
    public List<Serie> findByGreaterThanCountSeasons(Integer countSeasons) {
        return seasonRepository.findByGreaterThanCountSeasons(countSeasons);
    }

    @Override
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

}
