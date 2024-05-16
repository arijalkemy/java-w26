package com.dtoEntityDeportistasParte2.parte2.services.interfaces;
import com.dtoEntityDeportistasParte2.parte2.dto.DepostistaDTO;
import com.dtoEntityDeportistasParte2.parte2.entity.Deporte;

import java.util.List;

public interface IDeportistaService {
    List<Deporte> findAll();
    String findSport(String sport);
    List<DepostistaDTO> findSportsPersons();
}


