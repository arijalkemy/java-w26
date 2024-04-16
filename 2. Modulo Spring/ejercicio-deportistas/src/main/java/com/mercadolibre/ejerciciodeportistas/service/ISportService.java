package com.mercadolibre.ejerciciodeportistas.service;

import com.mercadolibre.ejerciciodeportistas.model.entity.Sport;

import java.util.List;

public interface ISportService {
    List<Sport> findAll();
    String findLevelByName(String name);
}
