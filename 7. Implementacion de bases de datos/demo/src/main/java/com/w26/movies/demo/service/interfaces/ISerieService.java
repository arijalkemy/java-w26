package com.w26.movies.demo.service.interfaces;

import java.util.List;

import com.w26.movies.demo.entity.Serie;

public interface ISerieService {
    public List<Serie> findByGreaterThanCountSeasons(Integer countSeasons);
    public List<Serie> findAll();
}
