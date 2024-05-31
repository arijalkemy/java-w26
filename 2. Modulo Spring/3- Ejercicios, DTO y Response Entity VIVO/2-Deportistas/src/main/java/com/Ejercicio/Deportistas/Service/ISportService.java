package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.DTO.SportDTO;

import java.util.List;

public interface ISportService {
    List<SportDTO> findAllSports();
    String findSportBy(String name);
}
