package com.ejercicio.deportistas.services.interfaces;

import com.ejercicio.deportistas.models.Sport;

import java.util.List;

public interface ISportsService {
    public List<Sport> getAllSports();

    public Sport getSportByName(String name);
}
