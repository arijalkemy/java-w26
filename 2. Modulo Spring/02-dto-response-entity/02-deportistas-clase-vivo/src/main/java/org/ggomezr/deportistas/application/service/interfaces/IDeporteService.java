package org.ggomezr.deportistas.application.service.interfaces;

import org.ggomezr.deportistas.domain.entity.Deporte;

import java.util.List;

public interface IDeporteService {
    List<Deporte> findSports();
    Deporte findSportByName(String deporte);
}
