package org.example.deportistas.services;

import org.example.deportistas.models.Deportes;
import org.example.deportistas.models.dtos.DeportistasResponseDTO;

import java.util.*;

public interface IDeportes {
    public List<Deportes> findSports();
    public Deportes findSport(String nameSport);
    public List<DeportistasResponseDTO> findSportsPerson();
}
