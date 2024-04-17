package com.ejerciciosdto.deportes.service;

import com.ejerciciosdto.deportes.models.Deporte;

import java.util.List;

public interface IDeporte {
    public List<Deporte> findSports();
    public String findSportByName(String name);
}
