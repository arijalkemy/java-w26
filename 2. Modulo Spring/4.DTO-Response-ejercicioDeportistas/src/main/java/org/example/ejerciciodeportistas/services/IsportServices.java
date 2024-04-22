package org.example.ejerciciodeportistas.services;

import org.example.ejerciciodeportistas.dto.SportDto;
import org.example.ejerciciodeportistas.models.Sport;

import java.util.List;

public interface IsportServices {
    List<Sport>  allSporst();
    SportDto sportByName(String name );
}
