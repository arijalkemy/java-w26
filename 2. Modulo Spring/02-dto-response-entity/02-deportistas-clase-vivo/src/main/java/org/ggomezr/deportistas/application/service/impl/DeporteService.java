package org.ggomezr.deportistas.application.service.impl;

import org.ggomezr.deportistas.application.service.interfaces.IDeporteService;
import org.ggomezr.deportistas.domain.entity.Deporte;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DeporteService implements IDeporteService {

    List<Deporte> deportes = Arrays.asList(
            new Deporte("Futbol", "Profesional"),
            new Deporte("Tennis", "Profesional"),
            new Deporte("Basketball", "Semiprofesional"),
            new Deporte("Volleyball", "Amateur")
    );

    @Override
    public List<Deporte> findSports() {
        return deportes;
    }

    @Override
    public Deporte findSportByName(String deporteAEncontrar) {
        return deportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(deporteAEncontrar)).findFirst().orElse(null);
    }
}
