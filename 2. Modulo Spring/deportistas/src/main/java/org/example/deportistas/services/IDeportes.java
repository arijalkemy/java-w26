package org.example.deportistas.services;

import org.example.deportistas.models.Deporte;
import org.example.deportistas.models.dtos.DeportistaResponseDTO;

import java.util.*;

public interface IDeportes {
    public List<Deporte> findSports();
    public Deporte findSport(String nameSport);
    public List<DeportistaResponseDTO> findSportsPerson();
}
