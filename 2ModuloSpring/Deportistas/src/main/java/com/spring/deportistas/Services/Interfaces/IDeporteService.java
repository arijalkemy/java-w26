package com.spring.deportistas.Services.Interfaces;

import com.spring.deportistas.Models.Deporte;

import java.util.List;

public interface IDeporteService {
    List<Deporte> getAllSports();

    String findLevelBySportName(String name);
}
