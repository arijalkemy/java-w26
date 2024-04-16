package org.example.ejerciciodeportistas.services;

import org.example.ejerciciodeportistas.entities.PersonDTO;
import org.example.ejerciciodeportistas.entities.Sport;

import java.util.List;

public interface ISportsService {
    List<Sport> getSports();

    String getSportByName(String name);

    List<PersonDTO> getSportsPersons();
}
