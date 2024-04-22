package com.example.deportes.service.impl;

import com.example.deportes.dto.SportsPersonsDTO;
import com.example.deportes.entity.Deporte;
import com.example.deportes.entity.Deportes;
import com.example.deportes.entity.Deportistas;
import com.example.deportes.entity.Inscripcion;
import com.example.deportes.service.ISportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImpl implements ISportService {

    Deportes deportes = new Deportes();
    Deportistas deportistas = new Deportistas();

    List<Inscripcion> bdInscripciones = List.of(
            new Inscripcion(deportistas.getDeportistas().get(0), List.of(deportes.getDeportes().get(3),deportes.getDeportes().get(5))),
            new Inscripcion(deportistas.getDeportistas().get(1), List.of(deportes.getDeportes().get(6))),
            new Inscripcion(deportistas.getDeportistas().get(2), List.of(deportes.getDeportes().get(2))),
            new Inscripcion(deportistas.getDeportistas().get(3), List.of(deportes.getDeportes().get(0))));


    @Override
    public List<Deporte> findAllSports() {
        return deportes.getDeportes();
    }

    @Override
    public Deporte findSportByName(String name) {
        return deportes.getDeportes()
                .stream()
                .filter(deporte -> deporte.getNombre().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public List<SportsPersonsDTO> findSportPerson() {
        List<SportsPersonsDTO> sportsPersonsList = new ArrayList<>();
        bdInscripciones.forEach(inscripcion -> {
            sportsPersonsList.add(new SportsPersonsDTO(inscripcion));
        });
        return sportsPersonsList;
    }
}
