package com.example.deportes.service;

import com.example.deportes.dto.SportsPersonsDTO;
import com.example.deportes.entity.Deporte;

import java.util.List;

public interface ISportService {
    List<Deporte> findAllSports();
    Deporte findSportByName(String name);

    List<SportsPersonsDTO> findSportPerson();
}
